package com.kt.gardenapp.service;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.model.PlantType;
import com.kt.gardenapp.repository.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PlantServiceTest {

    @Mock
    private PlantRepository plantRepository;

    private PlantService plantService;

    @BeforeEach
    void setUp() {
        plantService = new PlantService(plantRepository);
    }

    // findAll method returns a list of all plants
    @Test
    public void test_findAll_returnsListOfAllPlants() {
        // Arrange
        List<Plant> expectedPlants = new ArrayList<>();
        expectedPlants.add(new Plant(1L, PlantType.ALOE, new Garden()));
        expectedPlants.add(new Plant(2L, PlantType.AGAVE, new Garden()));
        expectedPlants.add(new Plant(3L, PlantType.AEONIUM, new Garden()));

        when(plantRepository.findAll()).thenReturn(expectedPlants);

        // Act
        List<Plant> actualPlants = plantService.findAll();

        // Assert
        assertEquals(expectedPlants, actualPlants);
    }

    // find method returns an optional containing the plant with the given id
    @Test
    public void test_find_returnsOptionalContainingPlantWithGivenId() {
        // Arrange
        Long id = 1L;
        Plant expectedPlant = new Plant(id, PlantType.ALOE, new Garden());

        when(plantRepository.findById(id)).thenReturn(Optional.of(expectedPlant));

        // Act
        Optional<Plant> actualPlant = plantService.find(id);

        // Assert
        assertTrue(actualPlant.isPresent());
        assertEquals(expectedPlant, actualPlant.get());
    }

    // save method saves a new plant to the repository
    @Test
    public void test_save_savesNewPlantToRepository() {
        // Arrange
        Plant plant = new Plant(1L, PlantType.ALOE, new Garden());

        // Act
        plantService.save(plant);

        // Assert
        verify(plantRepository).save(plant);
    }

    // find method returns an empty optional when given an id that does not exist
    @Test
    public void test_find_returnsEmptyOptionalWhenGivenNonexistentId() {
        // Arrange
        Long id = 1L;

        when(plantRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Plant> actualPlant = plantService.find(id);

        // Assert
        assertFalse(actualPlant.isPresent());
    }

    // save method updates an existing plant in the repository
    @Test
    public void test_save_updatesExistingPlantInRepository() {
        // Arrange
        Plant plant = new Plant(1L, PlantType.ALOE, new Garden());

        when(plantRepository.save(plant)).thenReturn(plant);

        // Act
        plantService.save(plant);

        // Assert
        verify(plantRepository).save(plant);
    }

    // findAll method returns an empty list when there are no plants in the repository
    @Test
    public void test_findAll_returnsEmptyListWhenNoPlantsInRepository() {
        // Arrange
        List<Plant> expectedPlants = new ArrayList<>();

        when(plantRepository.findAll()).thenReturn(expectedPlants);

        // Act
        List<Plant> actualPlants = plantService.findAll();

        // Assert
        assertEquals(expectedPlants, actualPlants);
    }

}
