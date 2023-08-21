package com.kt.gardenapp.model.DTOs;

import java.util.Set;

public record GardenDTO(
        Long id,
        Set<Long> plantIds
) {
}
