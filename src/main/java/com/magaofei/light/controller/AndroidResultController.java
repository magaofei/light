package com.magaofei.light.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author magaofei
 * scanning detail for android
 */
@RestController(value = "/api/scanning/android")
public class AndroidResultController {

    /**
     *
     * @param id 同 ScanningId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAndroidDetailScanningResult(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok().body("");
    }

}
