package com.kt.gardenapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.repository.GardenRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GardenService.class})
@ExtendWith(SpringExtension.class)
class GardenServiceTest {
    @MockBean
    private GardenRepository gardenRepository;

    @Autowired
    private GardenService gardenService;

    /**
     * Method under test: {@link GardenService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Garden> gardenList = new ArrayList<>();
        when(gardenRepository.findAll()).thenReturn(gardenList);
        List<Garden> actualFindAllResult = gardenService.findAll();
        assertSame(gardenList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(gardenRepository).findAll();
    }

    /**
     * Method under test: {@link GardenService#findById(String)}
     */
    @Test
    void testFindById() {
        Garden garden = new Garden();
        garden.setId(1L);
        garden.setPlants(new HashSet<>());
        Optional<Garden> ofResult = Optional.of(garden);
        when(gardenRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Garden> actualFindByIdResult = gardenService.findById("42");
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(gardenRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GardenService#save(Garden)}
     */
    @Test
    void testSave() {
        Garden garden = new Garden();
        garden.setId(1L);
        garden.setPlants(new HashSet<>());
        when(gardenRepository.save(Mockito.<Garden>any())).thenReturn(garden);

        Garden garden2 = new Garden();
        garden2.setId(1L);
        garden2.setPlants(new HashSet<>());
        gardenService.save(garden2);
        verify(gardenRepository).save(Mockito.<Garden>any());
        assertEquals(1L, garden2.getId().longValue());
        assertTrue(garden2.getPlants().isEmpty());
        assertTrue(gardenService.findAll().isEmpty());
    }
}

