package com.kt.gardenapp.kafka;

import com.kt.gardenapp.model.DTOs.PlantDTO;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;


@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, PlantCreatedEventDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, PlantCreatedEventDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PlantDTO plantDTO) {
        PlantCreatedEvent plantCreatedEvent = new PlantCreatedEvent(
                plantDTO.id(), plantDTO.type(), plantDTO.gardenId());

        System.out.println("KafkaProducerService log:");
        System.out.println(plantCreatedEvent);

        PlantCreatedEventDTO plantCreatedEventDTO = createPlantCreatedEventDTO(plantDTO);
        kafkaTemplate.send("garden-topic", plantCreatedEventDTO);
    }

    private PlantCreatedEventDTO createPlantCreatedEventDTO(PlantDTO plantDTO) {
        PlantCreatedEventDTO plantCreatedEventDTO = new PlantCreatedEventDTO(
                plantDTO.id(), plantDTO.type(), plantDTO.gardenId());
        return plantCreatedEventDTO;
    }
}

