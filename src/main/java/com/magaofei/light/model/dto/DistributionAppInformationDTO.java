package com.magaofei.light.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DistributionAppInformationDTO {
    /**
     * 网址 url
     */
    @NotNull
    @NotEmpty
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
