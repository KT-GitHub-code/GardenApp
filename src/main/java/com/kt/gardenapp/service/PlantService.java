package com.kt.gardenapp.service;

import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    public PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public void save(Plant plant) {
        plantRepository.save(plant);
    }
}
