package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlantController {

    public PlantRepository plantRepository;

    @GetMapping("/api/plants")
    public List<Plant> getPlants(){
        return plantRepository.findAll();
    }

    @PostMapping("/api/plant")
    public void addPlant(@RequestBody Plant plant){
        plantRepository.save(plant);
    }

}
