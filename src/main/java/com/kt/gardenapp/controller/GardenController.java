package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.service.GardenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class GardenController {

    public GardenService gardenService;

    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping("/api/gardens")
    public List<Garden> getGardens() {
        return gardenService.findAll();
    }

    @GetMapping("/api/gardens/{id}")
    public Optional<Garden> getGardenById(@PathVariable String id) {
        return gardenService.findById(id);
    }

    @GetMapping("/api/plantsbygardenid/{id}")
    public Set<Plant> getPlantsByGardenId(@PathVariable String id) {
        Optional<Garden> garden = gardenService.findById(id);
        Set<Plant> plants = null;
        if (garden.isPresent()) {
            plants = garden.get().getPlants();
        }
        return plants;
    }

    @PostMapping("/api/garden")
    public void addGarden(@RequestBody Garden garden) {
        gardenService.save(garden);
    }

}
