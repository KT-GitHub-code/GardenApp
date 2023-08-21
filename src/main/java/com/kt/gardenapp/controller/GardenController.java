package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.DTOs.GardenDTO;
import com.kt.gardenapp.model.DTOs.PlantDTO;
import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.service.DTOMappers.GardenDTOMapper;
import com.kt.gardenapp.service.DTOMappers.PlantDTOMapper;
import com.kt.gardenapp.service.GardenService;
import com.kt.gardenapp.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class GardenController {

    public GardenService gardenService;
    public GardenDTOMapper gardenDTOMapper;

    public PlantService plantService;
    public PlantDTOMapper plantDTOMapper;


    public GardenController(GardenService gardenService,
                            GardenDTOMapper gardenDTOMapper,
                            PlantService plantService,
                            PlantDTOMapper plantDTOMapper) {
        this.gardenService = gardenService;
        this.gardenDTOMapper = gardenDTOMapper;
        this.plantService = plantService;
        this.plantDTOMapper = plantDTOMapper;
    }

    @GetMapping("/api/gardens")
    public List<GardenDTO> getGardens() {
        return gardenService.findAll()
                .stream()
                .map(gardenDTOMapper)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/gardens/{id}")
    public Optional<GardenDTO> getGardenById(@PathVariable String id) {
        return gardenService.findById(id)
                .stream()
                .map(gardenDTOMapper)
                .findFirst();
    }

    @GetMapping("/api/plantsbygardenid/{id}")
    public Set<PlantDTO> getPlantsByGardenId(@PathVariable String id) {
        Optional<GardenDTO> gardenDTO = getGardenById(id);
        Set<PlantDTO> plantDTOs = new HashSet<>();
        Set<Long> plantIds;
        if (gardenDTO.isPresent()) {
            plantIds = gardenDTO.get().plantIds();
            for (Long plantId : plantIds) {
                if(plantService.find(plantId).isPresent()){
                    plantDTOs.add(plantDTOMapper.apply(plantService.find(plantId).get()));
                }

            }
        }
        return plantDTOs;
    }

    @PostMapping("/api/garden")
    public void addGarden(@RequestBody GardenDTO gardenDTO) {
        Garden garden = new Garden();
        BeanUtils.copyProperties(gardenDTO, new Garden());
        gardenService.save(garden);
    }

}
