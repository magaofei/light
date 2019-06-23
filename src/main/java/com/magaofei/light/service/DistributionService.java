package com.magaofei.light.service;

import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;
import com.magaofei.light.model.dto.DistributionAppInformationDTO;

public interface DistributionService {
    AppInformation getAppInformation(DistributionAppInformationDTO distributionAppInformationDTO);

    AppInformationUrl getAppInformationUrl(DistributionAppInformationDTO distributionAppInformationDTO);
}
