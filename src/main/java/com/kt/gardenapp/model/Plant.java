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

    public static PlantBuilder builder() {
        return new PlantBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Plant)) return false;
        final Plant other = (Plant) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$garden = this.getGarden();
        final Object other$garden = other.getGarden();
        if (this$garden == null ? other$garden != null : !this$garden.equals(other$garden)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Plant;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $garden = this.getGarden();
        result = result * PRIME + ($garden == null ? 43 : $garden.hashCode());
        return result;
    }

    public String toString() {
        return "Plant(id=" + this.getId() + ", type=" + this.getType() + ", garden=" + this.getGarden() + ")";
    }

    public static class PlantBuilder {
        private Long id;
        private PlantType type;
        private Garden garden;

        PlantBuilder() {
        }

        public PlantBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlantBuilder type(PlantType type) {
            this.type = type;
            return this;
        }

        public PlantBuilder garden(Garden garden) {
            this.garden = garden;
            return this;
        }

        public Plant build() {
            return new Plant(this.id, this.type, this.garden);
        }

        public String toString() {
            return "Plant.PlantBuilder(id=" + this.id + ", type=" + this.type + ", garden=" + this.garden + ")";
        }
    }
}
