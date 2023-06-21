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

    public static GardenBuilder builder() {
        return new GardenBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Garden)) return false;
        final Garden other = (Garden) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$plants = this.getPlants();
        final Object other$plants = other.getPlants();
        if (this$plants == null ? other$plants != null : !this$plants.equals(other$plants)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Garden;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $plants = this.getPlants();
        result = result * PRIME + ($plants == null ? 43 : $plants.hashCode());
        return result;
    }

    public String toString() {
        return "Garden(id=" + this.getId() + ", plants=" + this.getPlants() + ")";
    }

    public static class GardenBuilder {
        private Long id;
        private Set<Plant> plants;

        GardenBuilder() {
        }

        public GardenBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @JsonIgnore
        public GardenBuilder plants(Set<Plant> plants) {
            this.plants = plants;
            return this;
        }

        public Garden build() {
            return new Garden(this.id, this.plants);
        }

        public String toString() {
            return "Garden.GardenBuilder(id=" + this.id + ", plants=" + this.plants + ")";
        }
    }
}
