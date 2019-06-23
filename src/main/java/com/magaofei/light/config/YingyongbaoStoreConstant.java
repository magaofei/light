package com.magaofei.light.config;

import java.util.regex.Pattern;

public class YingyongbaoStoreConstant {
    private YingyongbaoStoreConstant() {}

    public static final String SITE_URL = "qq.com";

    public static final String MOBILE_SITE_URL = "a.app.qq.com";

    public static final String DESKTOP_SITE_URL = "sj.qq.com";

    public static final Pattern APP_INFO_DATA_PATTERN = Pattern.compile("try\\{\\s*window.AppInfoData=(.*);");

    public static final String MOBILE_URL = "https://a.app.qq.com/o/simple.jsp?pkgname=%s";

    public static final String APKNAME = "apkName";
}
