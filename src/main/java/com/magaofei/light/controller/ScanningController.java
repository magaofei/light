package com.magaofei.light.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author magaofei
 * 扫描记录
 */
@RestController(value = "/api/scanning")
public class ScanningController {

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getScanning(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok().body("");
    }

    @GetMapping()
    public ResponseEntity<?> listScanning(

    ) {
        return ResponseEntity.ok().body("");
    }

    /**
     * 提交任务
     * @return
     */
    @PostMapping
    public ResponseEntity<?> submitScanning() {
        return ResponseEntity.ok().body("");
    }


}
