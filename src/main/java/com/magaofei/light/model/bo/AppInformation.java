package com.magaofei.light.model.bo;

public class AppInformation {
    private Long size;
    private String sizeDescription;
    private String name;
    private String date;
    private String version;

    private String platform;

    private String build;
    private String icon;
    private String key;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "AppInformation{" +
                "size=" + size +
                ", sizeDescription='" + sizeDescription + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", version='" + version + '\'' +
                ", platform='" + platform + '\'' +
                ", build='" + build + '\'' +
                ", icon='" + icon + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
