package com.magaofei.light.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HuaweiAppInformation {


    public HuaweiAppInformation() {
    }

    public static class DataList {

        @JsonProperty("sizeDesc")
        private String sizeDescription;

        private String icon;

        @JsonProperty("targetSDK")
        private String targetSdk;

        @JsonProperty("versionName")
        private String version;

        private String trace;

        @JsonProperty("downurl")
        private String downloadUrl;

        @JsonProperty("package")
        private String packageName;

        private String versionCode;

        private Long size;

        private String appid;

        @JsonProperty("name")
        private String name;

        private String md5;

        @JsonProperty("releaseDate")
        private String date;

        public String getSizeDescription() {
            return sizeDescription;
        }

        public void setSizeDescription(String sizeDescription) {
            this.sizeDescription = sizeDescription;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTargetSdk() {
            return targetSdk;
        }

        public void setTargetSdk(String targetSdk) {
            this.targetSdk = targetSdk;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTrace() {
            return trace;
        }

        public void setTrace(String trace) {
            this.trace = trace;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public DataList() {
        }
    }
    public static class LayoutData {
        private Integer layoutId;
        private String layoutName;
        private List<DataList> dataList;

        public Integer getLayoutId() {
            return layoutId;
        }

        public void setLayoutId(Integer layoutId) {
            this.layoutId = layoutId;
        }

        public String getLayoutName() {
            return layoutName;
        }

        public void setLayoutName(String layoutName) {
            this.layoutName = layoutName;
        }

        public List<DataList> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataList> dataList) {
            this.dataList = dataList;
        }

    }

    private String statKey;

    private String rspKey;

    private Integer rtnCode;

    private Integer totalPages;

    private Integer count;

    private List<LayoutData> layoutData;


    public String getStatKey() {
        return statKey;
    }

    public void setStatKey(String statKey) {
        this.statKey = statKey;
    }

    public String getRspKey() {
        return rspKey;
    }

    public void setRspKey(String rspKey) {
        this.rspKey = rspKey;
    }

    public Integer getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(Integer rtnCode) {
        this.rtnCode = rtnCode;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<LayoutData> getLayoutData() {
        return layoutData;
    }

    public void setLayoutData(List<LayoutData> layoutData) {
        this.layoutData = layoutData;
    }

    @Override
    public String toString() {
        return "HuaweiAppInformation{" +
                "statKey='" + statKey + '\'' +
                ", rspKey='" + rspKey + '\'' +
                ", rtnCode=" + rtnCode +
                ", totalPages=" + totalPages +
                ", count=" + count +
                ", layoutData=" + layoutData +
                '}';
    }
}
