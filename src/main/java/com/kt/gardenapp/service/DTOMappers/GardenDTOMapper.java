package com.kt.gardenapp.service.DTOMappers;

import com.kt.gardenapp.model.DTOs.GardenDTO;
import com.kt.gardenapp.model.Garden;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class GardenDTOMapper implements Function<Garden, GardenDTO> {
    @Override
    public GardenDTO apply(Garden garden) {
        return new GardenDTO(garden.getId(),
                garden.getPlants()
                        .stream()
                        .map(plant -> plant.getId())
                        .collect(Collectors.toSet())
        );
    }
}
