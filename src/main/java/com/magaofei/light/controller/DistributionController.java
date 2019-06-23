package com.magaofei.light.controller;

import com.magaofei.light.model.bo.AppInformation;
import com.magaofei.light.model.bo.AppInformationUrl;
import com.magaofei.light.model.dto.DistributionAppInformationDTO;
import com.magaofei.light.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author magaofei
 */
@RestController(value = "/api/distribution")
public class DistributionController {

    @Autowired
    private DistributionService distributionService;

    @PostMapping
    public ResponseEntity<AppInformation> findAppInformation(
            @RequestBody @Valid DistributionAppInformationDTO distributionAppInformationDTO
            ) {
        return ResponseEntity.ok().body(this.distributionService.getAppInformation(distributionAppInformationDTO));
    }

    @PostMapping(value = "/url")
    public ResponseEntity<AppInformationUrl> findAppInformationAndUrl(
            @RequestBody @Valid DistributionAppInformationDTO distributionAppInformationDTO
    ) {
        return ResponseEntity.ok().body(this.distributionService.getAppInformationUrl(distributionAppInformationDTO));
    }


}
