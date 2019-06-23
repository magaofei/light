package com.magaofei.light.config;

/**
 * @author magaofei
 * App distribution enum
 */
public enum  DistributionEnum {
    /**
     *
     */
    PGYER,
    HUAWEI,
    YINGYONGBAO,
    MANUAL;

    public static DistributionEnum getDistributionEnumFromUrl(String url) {
        if (url.contains(HuaweiStoreConstant.APP_STORE_HUAWEI_URL)) {
            return HUAWEI;
        } else if (url.contains(YingyongbaoStoreConstant.SITE_URL)) {
            return YINGYONGBAO;
        } else {
            return null;
        }
    }


}
