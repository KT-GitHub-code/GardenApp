package com.kt.gardenapp.model.DTOs;

import com.kt.gardenapp.model.PlantType;

public record PlantDTO(
        Long id,
        PlantType type,
        Long gardenId
) {
}
