package com.magaofei.light.manager.distribution;

import com.magaofei.light.model.bo.AppInformation;

/**
 * @author magaofei
 */
public interface DistributionMarket {

    AppInformation getAppInformation(String url);

}
