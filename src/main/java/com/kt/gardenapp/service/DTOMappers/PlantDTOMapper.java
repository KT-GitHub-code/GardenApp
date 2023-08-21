package com.kt.gardenapp.service.DTOMappers;

import com.kt.gardenapp.model.DTOs.PlantDTO;
import com.kt.gardenapp.model.Plant;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlantDTOMapper implements Function<Plant, PlantDTO> {

    @Override
    public PlantDTO apply(Plant plant){
        return new PlantDTO(
                plant.getId(),
                plant.getType(),
                plant.getGarden().getId());
    }

}
