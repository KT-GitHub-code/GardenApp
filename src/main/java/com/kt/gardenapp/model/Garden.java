package com.kt.gardenapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Garden {

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "garden", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    public Set<Plant> plants;


}
