package com.kt.gardenapp;

import com.kt.gardenapp.model.Garden;
import com.kt.gardenapp.repository.GardenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class GardenRepositoryTest {

    @Autowired
    private GardenRepository testGardenRepository;

    // default method - testing not necessary
    @Test
    void shouldSaveGardenToDatabase(){
        // given
        Garden garden = new Garden();
        testGardenRepository.save(garden);

        // when
        Garden actual = testGardenRepository.findById(1L).get();

        // then
        assertEquals(garden,actual);
    }


}
