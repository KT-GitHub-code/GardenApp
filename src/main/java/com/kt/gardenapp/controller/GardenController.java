package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.GardenRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class GardenController {

    public GardenRepository gardenRepository;

    public GardenController(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @GetMapping("/api/gardens")
    public List<Garden> getGardens() {
        return gardenRepository.findAll();
    }

    @GetMapping("/api/gardens/{id}")
    public Optional<Garden> getGardenById(@PathVariable String id) {
        return gardenRepository.findById(Long.valueOf(id));
    }

    @GetMapping("/api/plantsbygardenid/{id}")
    public Set<Plant> getPlantsByGardenId(@PathVariable String id) {
        Optional<Garden> garden = gardenRepository.findById(Long.valueOf(id));
        Set<Plant> plants = null;
        if (garden.isPresent()) {
            plants = garden.get().getPlants();
        }
        return plants;
    }

    @PostMapping("/api/garden")
    public void addGarden(@RequestBody Garden garden) {
        gardenRepository.save(garden);
    }

}
