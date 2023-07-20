package com.kt.gardenapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Garden {

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "garden", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    public Set<Plant> plants;


    public Garden(Long id, Set<Plant> plants) {
        this.id = id;
        this.plants = plants;
    }

    public Garden() {
    }

    public Long getId() {
        return this.id;
    }

    public Set<Plant> getPlants() {
        return this.plants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public void setPlants(Set<Plant> plants) {
        this.plants = plants;
    }

    public String toString() {
        return "Garden(id=" + this.getId() + ", plants=" + this.getPlants() + ")";
    }

}
