/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain;

import com.maximilianol.age2api.HashCodes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author zaktorius
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String expansion;
    private String age;
    
    @ManyToOne
    private Structure created_in;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unit")
    private List<Resource> resources = new ArrayList<>();
    
    private String cost;
    private String build_time;
    private String reload_time;
    private String attack_delay;
    private String movement_rate;
    private String line_of_sight;
    private String hit_points;
    private String range;
    private String attack;
    private String armor;
    private String attack_bonus;
    private String armor_bonus;
    private String search_radius;
    private String accuracy;
    private String blast_radius;
    
    public void addResource(Resource resource) {
        resources.add(resource);
        resource.setUnit(this);
    }
    
    public void removeResource(Resource resource) {
        resources.remove(resource);
        resource.setUnit(null);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        return id != null && id.equals(((Unit) o).getId());
    }
    
    @Override
    public int hashCode() {
        return HashCodes.UNIT;
    }
}
