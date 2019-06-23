package com.magaofei.light.service.impl;

import com.magaofei.light.config.DistributionEnum;
import com.magaofei.light.exception.BadRequestException;
import com.magaofei.light.manager.distribution.DistributionMarketDownloader;
import com.magaofei.light.manager.distribution.DistributionMarketSimpleFactory;
import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;
import com.magaofei.light.model.dto.DistributionAppInformationDTO;
import com.magaofei.light.service.DistributionService;
import org.springframework.stereotype.Service;

/**
 * @author magaofei
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Override
    public AppInformation getAppInformation(DistributionAppInformationDTO distributionAppInformationDTO) {
        String url = distributionAppInformationDTO.getUrl();
        DistributionEnum distributionEnum = DistributionEnum.getDistributionEnumFromUrl(url);
        DistributionMarketDownloader distributionMarketDownloader = DistributionMarketSimpleFactory.getDistribution(distributionEnum);
        if (null == distributionMarketDownloader) {
            throw new BadRequestException("url错误");
        }
        return distributionMarketDownloader.getAppInformation(url);
    }

    @Override
    public AppInformationUrl getAppInformationUrl(DistributionAppInformationDTO distributionAppInformationDTO) {
        return this.getAppInformation(distributionAppInformationDTO.getUrl());
    }

    private AppInformationUrl getAppInformation(String url) {

        DistributionEnum distributionEnum = DistributionEnum.getDistributionEnumFromUrl(url);
        DistributionMarketDownloader distributionMarketDownloader = DistributionMarketSimpleFactory.getDistribution(distributionEnum);
        if (null == distributionMarketDownloader) {
            throw new BadRequestException("url错误");
        }
        return distributionMarketDownloader.getAppInformationAndUrl(url);
    }


}
