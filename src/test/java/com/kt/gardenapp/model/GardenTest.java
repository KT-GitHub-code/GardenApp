package com.kt.gardenapp.model;


import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {


    // can be instantiated with an empty set of plants
    @Test
    public void test_instantiation_with_empty_set_of_plants() {
        // Arrange
        Set<Plant> plants = new HashSet<>();

        // Act
        Garden garden = new Garden(1L, plants);

        // Assert
        assertNotNull(garden);
        assertEquals(1L, garden.getId());
        assertEquals(plants, garden.getPlants());
    }

    @Test
    public void test_retrieve_id() {
        // Arrange
        Garden garden = new Garden(1L, new HashSet<>());

        // Act
        Long id = garden.getId();

        // Assert
        assertEquals(1L, id);
    }

    @Test
    public void test_retrieve_plants() {
        // Arrange
        Set<Plant> plants = new HashSet<>();
        plants.add(new Plant(1L, PlantType.ALOE, new Garden()));
        plants.add(new Plant(2L, PlantType.AGAVE, new Garden()));

        Garden garden = new Garden(1L, plants);

        // Act
        Set<Plant> retrievedPlants = garden.getPlants();

        // Assert
        assertEquals(plants, retrievedPlants);
    }

    @Test
    public void test_set_id() {
        // Arrange
        Garden garden = new Garden();

        // Act
        garden.setId(1L);

        // Assert
        assertEquals(1L, garden.getId());
    }

    @Test
    public void test_set_plants() {
        // Arrange
        Set<Plant> plants = new HashSet<>();
        plants.add(new Plant(1L, PlantType.ALOE, new Garden()));
        plants.add(new Plant(2L, PlantType.AGAVE, new Garden()));

        Garden garden = new Garden();

        // Act
        garden.setPlants(plants);

        // Assert
        assertEquals(plants, garden.getPlants());
    }

    @Test
    public void test_to_string() {
        // Arrange
        Garden garden = new Garden(1L, new HashSet<>());

        // Act & Assert
        assertEquals("Garden(id=1, plants=[])",garden.toString());
    }

    @Test
    public void test_instantiation_with_null_set_of_plants() {
        // Arrange & Act
        Garden garden = new Garden(1L, null);

        // Assert
        assertNotNull(garden);
        assertEquals(1L, garden.getId());
        assertNull(garden.getPlants());
    }

}
