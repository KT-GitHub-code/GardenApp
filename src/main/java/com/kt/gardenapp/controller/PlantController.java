package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.PlantRepository;
import com.kt.gardenapp.service.PlantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantController {

    public PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/api/plants")
    public List<Plant> getPlants() {
        return plantService.findAll();
    }

    @PostMapping("/api/plant")
    public void addPlant(@RequestBody Plant plant) {
        plantService.save(plant);
    }

}
