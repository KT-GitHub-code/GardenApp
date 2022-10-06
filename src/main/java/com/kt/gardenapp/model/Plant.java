package com.kt.gardenapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    public PlantType type;

    @ManyToOne
    public Garden garden;



}
