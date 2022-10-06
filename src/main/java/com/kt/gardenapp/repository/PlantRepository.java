package com.kt.gardenapp.repository;

import com.kt.gardenapp.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
