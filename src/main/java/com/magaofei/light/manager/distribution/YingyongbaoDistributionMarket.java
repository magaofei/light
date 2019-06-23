package com.magaofei.light.manager.distribution;

import com.magaofei.light.config.Constants;
import com.magaofei.light.config.PlatformEnum;
import com.magaofei.light.config.YingyongbaoStoreConstant;
import com.magaofei.light.exception.BadRequestException;
import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;
import com.magaofei.light.model.bo.YingyongbaoAppInformation;
import com.magaofei.light.util.ObjectMapperProvider;
import com.magaofei.light.util.RestTemplateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;

public class YingyongbaoDistributionMarket implements DistributionMarketDownloader {

    private static final Logger logger = LoggerFactory.getLogger(YingyongbaoDistributionMarket.class);

    @Override
    public AppInformation getAppInformation(String url) {
        AppInformationUrl appInformationUrl = this.getAppInformationAndUrl(url);
        AppInformation appInformation = new AppInformation();
        BeanUtils.copyProperties(appInformationUrl, appInformation);
        return appInformation;
    }

    @Override
    public AppInformationUrl getAppInformationAndUrl(String url) {

        RestTemplate restTemplate = RestTemplateClient.getInstance();
        String body;
        String realUrl = this.getRealUrl(url);
        try {
            body = restTemplate.getForObject(URI.create(realUrl), String.class);
        } catch (RestClientException e) {
            logger.warn("e = ", e);
            throw new BadRequestException("访问失败");
        }
        if (body == null || body.isEmpty()) {
            logger.warn("body = empty, url = {}", realUrl);
            throw new BadRequestException("访问失败");
        }

        Matcher matcher = YingyongbaoStoreConstant.APP_INFO_DATA_PATTERN.matcher(body);
        String appInfoData = "";
        if (matcher.find()) {
            appInfoData = matcher.group(matcher.groupCount());
        }

        if (appInfoData.isEmpty()) {
            logger.warn("解析失败, body = {}", body);
            throw new BadRequestException("解析失败");
        }

        YingyongbaoAppInformation yingyongbaoAppInfoData;
        try {
            yingyongbaoAppInfoData = ObjectMapperProvider.OBJECT_MAPPER.readValue(appInfoData, YingyongbaoAppInformation.class);
        } catch (IOException e) {
            logger.warn("转换失败, appInfoData = {}, e = ", appInfoData, e);
            throw new BadRequestException("转换失败");
        }

        AppInformationUrl appInformationUrl = new AppInformationUrl();
        this.convertYingyongbaoAppInfoDataToAppInformationUrl(yingyongbaoAppInfoData, appInformationUrl);

        return appInformationUrl;
    }

    private void convertYingyongbaoAppInfoDataToAppInformationUrl(
            YingyongbaoAppInformation yingyongbaoAppInfoData, AppInformationUrl appInformationUrl) {
        appInformationUrl.setSizeDescription(yingyongbaoAppInfoData.getAppDetail().getFileSize().getDesc());
        appInformationUrl.setSize(yingyongbaoAppInfoData.getAppDetail().getFileSize().getBytes());
        appInformationUrl.setPlatform(PlatformEnum.ANDROID.toString());
        appInformationUrl.setIcon(yingyongbaoAppInfoData.getAppDetail().getIconUrl());
        appInformationUrl.setName(yingyongbaoAppInfoData.getAppDetail().getAppName());
        appInformationUrl.setBuild(Constants.DEFAULT_BUILD);
        appInformationUrl.setVersion(yingyongbaoAppInfoData.getAppDetail().getVersionName());
        appInformationUrl.setDate(yingyongbaoAppInfoData.getAppDetail().getPublishTime());
        appInformationUrl.setKey(yingyongbaoAppInfoData.getAppDetail().getApkMd5());
        appInformationUrl.setUrl(yingyongbaoAppInfoData.getAppDetail().getApkUrl());

    }

    private String getRealUrl(String url) {

        if (url.contains(YingyongbaoStoreConstant.MOBILE_SITE_URL)) {
            return url;
        }

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).build();
        MultiValueMap<String, String> map = uriComponents.getQueryParams();
        String apkName = map.getFirst(YingyongbaoStoreConstant.APKNAME);
        return getMobileUrl(apkName);
    }

    private String getMobileUrl(String packageName) {
        return String.format(YingyongbaoStoreConstant.MOBILE_URL, packageName);
    }
}
