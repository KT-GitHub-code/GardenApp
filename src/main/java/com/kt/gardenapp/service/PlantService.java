package com.kt.gardenapp.service;

import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.PlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    public PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public Optional<Plant> find(Long id){
        return plantRepository.findById(id);
    }

    @Transactional
    public Plant save(Plant plant) {
        if (plant == null) {
            throw new IllegalArgumentException("Plant parameter cannot be null");
        }
        return plantRepository.save(plant);
    }
}
