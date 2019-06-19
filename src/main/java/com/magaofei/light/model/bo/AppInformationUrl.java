package com.magaofei.light.model.bo;

public class AppInformationUrl extends AppInformation {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return super.toString() + "AppInformationUrl{" +
                "url='" + url + '\'' +
                '}';
    }
}
