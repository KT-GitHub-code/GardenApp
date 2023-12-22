package com.kt.gardenapp.controller;

import com.kt.gardenapp.kafka.KafkaProducerService;
import com.kt.gardenapp.model.DTOs.PlantDTO;
import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.service.DTOMappers.PlantDTOMapper;
import com.kt.gardenapp.service.GardenService;
import com.kt.gardenapp.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PlantController {

    public PlantService plantService;
    public PlantDTOMapper plantDTOMapper;
    public GardenService gardenService;
    public KafkaProducerService kafkaProducerService;


    public PlantController(PlantService plantService, PlantDTOMapper plantDTOMapper, GardenService gardenService, KafkaProducerService kafkaProducerService) {
        this.plantService = plantService;
        this.plantDTOMapper = plantDTOMapper;
        this.gardenService = gardenService;
        this.kafkaProducerService = kafkaProducerService;
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
    public void addPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant();
        plant.setType(plantDTO.type());
        Optional<Garden> garden = gardenService.findById(String.valueOf(plantDTO.gardenId()));
        if(garden.isPresent()){
            plant.setGarden(garden.get());
        }
        plantService.save(plant);

        // Kafka message
        kafkaProducerService.sendMessage(plantDTO);
    }

}
