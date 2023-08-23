package com.kt.gardenapp;

import com.kt.gardenapp.model.Plant;
import com.kt.gardenapp.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository testPlantRepository;

    // default method - testing not necessary
    @Test
    void shouldSavePlantToDatabase(){
        // given
        Plant plant = new Plant();
        testPlantRepository.save(plant);

        // when
        Plant actual = testPlantRepository.findById(1L).get();

        // then
        assertEquals(plant,actual);
    }

}
