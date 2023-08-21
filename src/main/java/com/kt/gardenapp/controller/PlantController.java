package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.DTOs.PlantDTO;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.service.DTOMappers.PlantDTOMapper;
import com.kt.gardenapp.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PlantController {

    public PlantService plantService;
    public PlantDTOMapper plantDTOMapper;

    public PlantController(PlantService plantService, PlantDTOMapper plantDTOMapper) {
        this.plantService = plantService;
        this.plantDTOMapper = plantDTOMapper;
    }

    @GetMapping("/api/plants")
    public List<PlantDTO> getPlants() {
        return plantService.findAll()
                .stream()
                .map(plantDTOMapper)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/plants/{id}")
    public Optional<PlantDTO> getPlantById(@PathVariable Long id){
        return plantService.find(id).map(plantDTOMapper);
    }

    @PostMapping("/api/plant")
    public void addPlant(@RequestBody Plant plant) {
        plantService.save(plant);
    }

}
