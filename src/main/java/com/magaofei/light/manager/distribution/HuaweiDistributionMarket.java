package com.magaofei.light.manager.distribution;

import com.magaofei.light.config.Constants;
import com.magaofei.light.config.HuaweiStoreConstant;
import com.magaofei.light.config.PlatformEnum;
import com.magaofei.light.exception.BadRequestException;
import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;
import com.magaofei.light.model.bo.HuaweiAppInformation;
import com.magaofei.light.util.HttpHeader;
import com.magaofei.light.util.ObjectMapperProvider;
import com.magaofei.light.util.RestTemplateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.Charset;

public class HuaweiDistributionMarket implements DistributionMarketDownloader {

    private static final Logger logger = LoggerFactory.getLogger(HuaweiDistributionMarket.class);

    @Override
    public AppInformation getAppInformation(String url) {
        AppInformationUrl appInformationUrl = this.getAppInformationFromHuawei(url);
        AppInformation appInformation = new AppInformation();
        BeanUtils.copyProperties(appInformationUrl, appInformation);
        return appInformation;
    }

    @Override
    public AppInformationUrl getAppInformationAndUrl(String url) {
        return this.getAppInformationFromHuawei(url);
    }

    private HuaweiAppInformation getHuaweiStoreAppInformation(String urlPath) throws
            HttpClientErrorException, HttpServerErrorException, ClassCastException, IOException {

        RestTemplate restTemplate = RestTemplateClient.getInstance();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HuaweiStoreConstant.HUAWEI_APP_INFORMATION_URL)
                .queryParam("method", "internal.getTabDetail")
                .queryParam("serviceType", "13")
                .queryParam("reqPageNum", "1")
                .queryParam("uri", urlPath)
                .queryParam("maxResults", "10");

        HttpEntity httpEntity = new HttpEntity(HttpHeader.commonHeaders());

        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity responseEntity =  restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, httpEntity, String.class);

        return ObjectMapperProvider.OBJECT_MAPPER.readValue(String.valueOf(responseEntity.getBody()), HuaweiAppInformation.class);
    }

    private String getLastFilePathFromHuaweiStore(String url) {

        String lastUrlPath = "";
        if (url.toLowerCase().startsWith(Constants.HTTP)) {
            lastUrlPath = url.replace(Constants.HTTP, "");
        } else if (url.toLowerCase().startsWith(Constants.HTTPS)) {
            lastUrlPath = url.replace(Constants.HTTPS, "");
        }

        if (lastUrlPath.toLowerCase().startsWith(HuaweiStoreConstant.APP_STORE_HUAWEI_URL)) {
            lastUrlPath = lastUrlPath.replace(HuaweiStoreConstant.APP_STORE_HUAWEI_URL, "");
        }

        return lastUrlPath.replace("/", "|");
    }

    private AppInformationUrl getAppInformationFromHuawei(String urlPath) {
        String lastUrlPath = this.getLastFilePathFromHuaweiStore(urlPath);
        String appId = lastUrlPath.replace(HuaweiStoreConstant.APP_, "");
        HuaweiAppInformation huaweiAppInformation;
        try {
            huaweiAppInformation = getHuaweiStoreAppInformation(lastUrlPath);
        } catch (IOException e) {
            logger.warn("解析失败，e = ", e);
            throw new BadRequestException("解析失败");
        }

        String date = "";
        HuaweiAppInformation.DataList dataList = null;

        for (HuaweiAppInformation.LayoutData layoutData: huaweiAppInformation.getLayoutData()) {
            for (HuaweiAppInformation.DataList tempDataList : layoutData.getDataList()) {
                if (tempDataList.getAppid() == null || tempDataList.getAppid().isEmpty()) {
                    continue;
                }
                if (tempDataList.getAppid().equals(appId)) {
                    if (tempDataList.getDate() == null) {
                        dataList = tempDataList;
                    } else {
                        date = tempDataList.getDate();
                    }
                }
            }
        }

        if (dataList == null) {
            logger.warn("Huawei App Information dataList == null， huaweiAppInformation = {}", huaweiAppInformation);
            throw new BadRequestException("dataList 数据获取失败");
        }

        AppInformationUrl appInformationUrl = new AppInformationUrl();

        BeanUtils.copyProperties(dataList, appInformationUrl);
        appInformationUrl.setPlatform(PlatformEnum.ANDROID.toString());
        appInformationUrl.setDate(date);

        appInformationUrl.setBuild(Constants.DEFAULT_BUILD);
        appInformationUrl.setKey(dataList.getMd5());
        appInformationUrl.setUrl(dataList.getDownloadUrl());
        return appInformationUrl;
    }


}
