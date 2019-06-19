package com.magaofei.light.manager.distribution;

import com.magaofei.light.model.bo.AppInformationUrl;

/**
 * @author magaofei
 */
public interface DistributionMarketDownloader extends DistributionMarket {
    AppInformationUrl getAppInformationAndUrl(String url);
}
