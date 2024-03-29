package com.kt.gardenapp.service;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.repository.GardenRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenService {

    public GardenRepository gardenRepository;

    public GardenService(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    public List<Garden> findAll() {
        return gardenRepository.findAll();
    }

    public Optional<Garden> findById(String id) {
        return gardenRepository.findById(Long.valueOf(id));
    }

    @Transactional
    public Garden save(Garden garden) {
        if (garden == null) {
            throw new IllegalArgumentException("Garden parameter cannot be null");
        }
        return gardenRepository.save(garden);
    }
}
