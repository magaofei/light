package com.magaofei.light.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "/api/scanning/ios")
public class IosResultController {

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getIosDetail(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok().body("");

    }
}
