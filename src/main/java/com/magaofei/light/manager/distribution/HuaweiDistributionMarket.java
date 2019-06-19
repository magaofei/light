package com.magaofei.light.manager.distribution;

import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;

public class HuaweiDistributionMarket implements DistributionMarketDownloader {
    
    @Override
    public AppInformation getAppInformation(String url) {
        return null;
    }

    @Override
    public AppInformationUrl getAppInformationAndUrl(String url) {
        return null;
    }
}
