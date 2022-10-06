package com.kt.gardenapp.repository;

import com.kt.gardenapp.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepository extends JpaRepository<Garden, Long> {
}
