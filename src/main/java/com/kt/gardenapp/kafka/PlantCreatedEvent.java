package com.kt.gardenapp.kafka;

import com.kt.gardenapp.model.PlantType;

public class PlantCreatedEvent {
    private Long plantID;
    private PlantType plantType;
    private Long gardenId;

    public PlantCreatedEvent(Long plantID, PlantType plantType, Long gardenId) {
        this.plantID = plantID;
        this.plantType = plantType;
        this.gardenId = gardenId;
    }

    @Override
    public String toString() {
        return "PlantCreatedEvent{" +
                "plantID=" + plantID +
                ", plantType=" + plantType +
                ", gardenId=" + gardenId +
                '}';
    }
}
