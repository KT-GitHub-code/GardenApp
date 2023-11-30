package com.kt.gardenapp.service;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.repository.GardenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GardenServiceTest {

    @Mock
    private GardenRepository gardenRepository;

    @Test
    public void test_retrieve_all_gardens() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        List<Garden> expectedGardens = new ArrayList<>();
        expectedGardens.add(new Garden(1L, new HashSet<>()));
        expectedGardens.add(new Garden(2L, new HashSet<>()));

        when(gardenRepository.findAll()).thenReturn(expectedGardens);

        // Act
        List<Garden> actualGardens = gardenService.findAll();

        // Assert
        assertEquals(expectedGardens, actualGardens);
    }

    @Test
    public void test_retrieve_garden_by_id() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        Garden expectedGarden = new Garden(1L, new HashSet<>());

        when(gardenRepository.findById(1L)).thenReturn(Optional.of(expectedGarden));

        // Act
        Optional<Garden> actualGarden = gardenService.findById("1");

        // Assert
        assertEquals(Optional.of(expectedGarden), actualGarden);
    }

    @Test
    public void test_save_new_garden() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        Garden gardenToSave = new Garden(1L, new HashSet<>());

        // Act
        gardenService.save(gardenToSave);

        // Assert
        verify(gardenRepository, times(1)).save(gardenToSave);
    }

    @Test
    public void test_handle_empty_list_of_gardens() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        List<Garden> expectedGardens = new ArrayList<>();

        when(gardenRepository.findAll()).thenReturn(expectedGardens);

        // Act
        List<Garden> actualGardens = gardenService.findAll();

        // Assert
        assertEquals(expectedGardens, actualGardens);
    }

    @Test
    public void test_handle_null_garden_returned_by_findById() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        when(gardenRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Garden> actualGarden = gardenService.findById("1");

        // Assert
        assertEquals(Optional.empty(), actualGarden);
    }

    @Test
    public void test_handle_null_garden_passed_to_save() {
        // Arrange
        GardenService gardenService = new GardenService(gardenRepository);

        Garden gardenToSave = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> gardenService.save(gardenToSave));
        assertEquals("Garden parameter cannot be null", exception.getMessage());
    }

}
