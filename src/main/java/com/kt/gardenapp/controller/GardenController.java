package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.repository.GardenRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GardenController {

    public GardenRepository gardenRepository;

    @GetMapping("/api/gardens")
    public List<Garden> getGardens(){
        return gardenRepository.findAll();
    }

    @PostMapping("/api/garden")
    public void addGarden(@RequestBody Garden garden){
        gardenRepository.save(garden);
    }

}
