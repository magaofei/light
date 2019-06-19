package com.magaofei.light.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author magaofei
 */
@RestController(value = "/api/distribution")
public class DistributionController {

    @PostMapping
    public ResponseEntity<?> findAppInformation() {
        return ResponseEntity.ok().body("");
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/url")
    public ResponseEntity<?> findAppInformationAndUrl() {
        return ResponseEntity.ok().body("");
    }


}
