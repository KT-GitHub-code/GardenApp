package com.kt.gardenapp.model;

import javax.persistence.*;

@Entity
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    public PlantType type;

    @ManyToOne
    public Garden garden;


    public Plant(Long id, PlantType type, Garden garden) {
        this.id = id;
        this.type = type;
        this.garden = garden;
    }

    public Plant() {
    }

    public Long getId() {
        return this.id;
    }

    public PlantType getType() {
        return this.type;
    }

    public Garden getGarden() {
        return this.garden;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public String toString() {
        return "Plant(id=" + this.getId() + ", type=" + this.getType() + ", garden=" + this.getGarden() + ")";
    }

}
