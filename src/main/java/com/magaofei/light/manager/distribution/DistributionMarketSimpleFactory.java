package com.magaofei.light.manager.distribution;

import com.magaofei.light.config.DistributionEnum;

public class DistributionMarketSimpleFactory {
    public static DistributionMarketDownloader getDistribution(DistributionEnum distributionEnum) {
        if (distributionEnum == null) {
            return null;
        }
        DistributionMarketDownloader distributionMarketDownloader = null;
        switch (distributionEnum) {
            case HUAWEI:
                distributionMarketDownloader = new HuaweiDistributionMarket();
                break;
            case YINGYONGBAO:
                distributionMarketDownloader = new YingyongbaoDistributionMarket();
                break;
                default:
                    break;
        }

        return distributionMarketDownloader;
    }
}
