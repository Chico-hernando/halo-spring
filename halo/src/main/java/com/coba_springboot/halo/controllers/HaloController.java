package com.coba_springboot.halo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coba_springboot.halo.model.apiResponse;



@RestController
@RequestMapping("/api")
public class HaloController {

    @RequestMapping("/halo")
    public String halo() {
        return "Halo";
    }

    @GetMapping("/response")
    public apiResponse<String> getResponse() {
        String data = "This is the data";
        return new apiResponse<>(200, "Success Response", data);
    }

    // @SuppressWarnings("rawtypes")
    // @PostMapping(value = "/response", consumes = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<apiResponse> createItem(@RequestBody String entity) {
    //     try {
    //         apiResponse response = new apiResponse<>(201, "Item created successfully", entity);
    //         return ResponseEntity.status(201).body(response);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(400).body(new apiResponse<>(400, "Failed to create item", null));
    //     }
    // }
    
    
}
