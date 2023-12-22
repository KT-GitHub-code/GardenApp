package com.kt.gardenapp.kafka;

import com.kt.gardenapp.model.PlantType;

public record PlantCreatedEventDTO(
        Long plantID,
        PlantType plantType,
        Long gardenId
) {
}
