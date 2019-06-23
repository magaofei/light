package com.magaofei.light.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YingyongbaoAppInformation {

    private AppExt appExt;

    private BaoPkg baoPkg;

    private AppDetail appDetail;

    private Integer ret;

    public YingyongbaoAppInformation() {
    }

    public static class BaoPkg {
        private Integer apkid;
        private Integer channel;
        private String url;
        private String md5;
        private Long size;

        @JsonProperty("https_url")
        private String httpsUrl;

        @JsonProperty("http_url")
        private String httpUrl;

        public Integer getApkid() {
            return apkid;
        }

        public void setApkid(Integer apkid) {
            this.apkid = apkid;
        }

        public Integer getChannel() {
            return channel;
        }

        public void setChannel(Integer channel) {
            this.channel = channel;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getHttpsUrl() {
            return httpsUrl;
        }

        public void setHttpsUrl(String httpsUrl) {
            this.httpsUrl = httpsUrl;
        }

        public String getHttpUrl() {
            return httpUrl;
        }

        public void setHttpUrl(String httpUrl) {
            this.httpUrl = httpUrl;
        }
    }

    public static class AppDetail {
        private Integer appId;
        private String packageName;
        private String appName;
        private String author;
        private String iconUrl;
        private String signatureMd5;
        private Integer versionCode;
        private String versionName;
        private String apkUrl;
        private String lang;
        private String apkMd5;
        private FileSize fileSize;
        private String publishTime;

        public Integer getAppId() {
            return appId;
        }

        public void setAppId(Integer appId) {
            this.appId = appId;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getSignatureMd5() {
            return signatureMd5;
        }

        public void setSignatureMd5(String signatureMd5) {
            this.signatureMd5 = signatureMd5;
        }

        public Integer getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(Integer versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getApkMd5() {
            return apkMd5;
        }

        public void setApkMd5(String apkMd5) {
            this.apkMd5 = apkMd5;
        }

        public FileSize getFileSize() {
            return fileSize;
        }

        public void setFileSize(FileSize fileSize) {
            this.fileSize = fileSize;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }
    }

    public static class FileSize {
        private Long bytes;
        private String desc;

        public Long getBytes() {
            return bytes;
        }

        public void setBytes(Long bytes) {
            this.bytes = bytes;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }


    public static class AppExt {
        private Integer appId;
        private String pkgName;
        private String iosUrl;
        private String sigMd5;
        private Integer channel;

        public Integer getAppId() {
            return appId;
        }

        public void setAppId(Integer appId) {
            this.appId = appId;
        }

        public String getPkgName() {
            return pkgName;
        }

        public void setPkgName(String pkgName) {
            this.pkgName = pkgName;
        }

        public String getIosUrl() {
            return iosUrl;
        }

        public void setIosUrl(String iosUrl) {
            this.iosUrl = iosUrl;
        }

        public String getSigMd5() {
            return sigMd5;
        }

        public void setSigMd5(String sigMd5) {
            this.sigMd5 = sigMd5;
        }

        public Integer getChannel() {
            return channel;
        }

        public void setChannel(Integer channel) {
            this.channel = channel;
        }
    }

    public AppExt getAppExt() {
        return appExt;
    }

    public void setAppExt(AppExt appExt) {
        this.appExt = appExt;
    }

    public BaoPkg getBaoPkg() {
        return baoPkg;
    }

    public void setBaoPkg(BaoPkg baoPkg) {
        this.baoPkg = baoPkg;
    }

    public AppDetail getAppDetail() {
        return appDetail;
    }

    public void setAppDetail(AppDetail appDetail) {
        this.appDetail = appDetail;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "YingyongbaoAppInfoData{" +
                "appExt=" + appExt +
                ", baoPkg=" + baoPkg +
                ", appDetail=" + appDetail +
                ", ret=" + ret +
                '}';
    }
}
