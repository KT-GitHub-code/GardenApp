package com.kt.gardenapp.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlantTest {


    // creating a new Plant object with valid parameters should return a non-null object
    @Test
    public void test_create_new_plant_with_valid_parameters() {
        // Arrange
        Long id = 1L;
        PlantType type = PlantType.ALOE;
        Garden garden = new Garden();

        // Act
        Plant plant = new Plant(id, type, garden);

        // Assert
        assertNotNull(plant);
    }

    // getting the id of a Plant object should return the correct id
    @Test
    public void test_get_id_of_plant_object() {
        // Arrange
        Long id = 1L;
        PlantType type = PlantType.ALOE;
        Garden garden = new Garden();
        Plant plant = new Plant(id, type, garden);

        // Act
        Long actualId = plant.getId();

        // Assert
        assertEquals(id, actualId);
    }

    // getting the type of a Plant object should return the correct type
    @Test
    public void test_get_type_of_plant_object() {
        // Arrange
        Long id = 1L;
        PlantType type = PlantType.ALOE;
        Garden garden = new Garden();
        Plant plant = new Plant(id, type, garden);

        // Act
        PlantType actualType = plant.getType();

        // Assert
        assertEquals(type, actualType);
    }

    // getting the garden of a Plant object should return the correct garden
    @Test
    public void test_get_garden() {
        // Arrange
        Long id = 1L;
        PlantType type = PlantType.ALOE;
        Garden garden = new Garden();
        Plant plant = new Plant(id, type, garden);

        // Act
        Garden actualGarden = plant.getGarden();

        // Assert
        assertEquals(garden, actualGarden);
    }

}
