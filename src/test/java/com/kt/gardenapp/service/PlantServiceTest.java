package com.kt.gardenapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.model.PlantType;
import com.kt.gardenapp.repository.PlantRepository;

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

@ContextConfiguration(classes = {PlantService.class})
@ExtendWith(SpringExtension.class)
class PlantServiceTest {
    @MockBean
    private PlantRepository plantRepository;

    @Autowired
    private PlantService plantService;

    /**
     * Method under test: {@link PlantService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Plant> plantList = new ArrayList<>();
        when(plantRepository.findAll()).thenReturn(plantList);
        List<Plant> actualFindAllResult = plantService.findAll();
        assertSame(plantList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(plantRepository).findAll();
    }

    /**
     * Method under test: {@link PlantService#find(Long)}
     */
    @Test
    void testFind() {
        Garden garden = new Garden();
        garden.setId(1L);
        garden.setPlants(new HashSet<>());

        Plant plant = new Plant();
        plant.setGarden(garden);
        plant.setId(1L);
        plant.setType(PlantType.AEONIUM);
        Optional<Plant> ofResult = Optional.of(plant);
        when(plantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Plant> actualFindResult = plantService.find(1L);
        assertSame(ofResult, actualFindResult);
        assertTrue(actualFindResult.isPresent());
        verify(plantRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link PlantService#save(Plant)}
     */
    @Test
    void testSave() {
        Garden garden = new Garden();
        garden.setId(1L);
        garden.setPlants(new HashSet<>());

        Plant plant = new Plant();
        plant.setGarden(garden);
        plant.setId(1L);
        plant.setType(PlantType.AEONIUM);
        when(plantRepository.save(Mockito.<Plant>any())).thenReturn(plant);

        Garden garden2 = new Garden();
        garden2.setId(1L);
        garden2.setPlants(new HashSet<>());

        Plant plant2 = new Plant();
        plant2.setGarden(garden2);
        plant2.setId(1L);
        plant2.setType(PlantType.AEONIUM);
        plantService.save(plant2);
        verify(plantRepository).save(Mockito.<Plant>any());
        assertSame(garden2, plant2.getGarden());
        assertEquals(PlantType.AEONIUM, plant2.getType());
        assertEquals(1L, plant2.getId().longValue());
        assertTrue(plantService.findAll().isEmpty());
    }
}

