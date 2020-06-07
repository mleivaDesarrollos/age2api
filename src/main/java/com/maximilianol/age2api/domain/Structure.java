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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author zaktorius
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="resources")
@Table(name = "structure")
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String expansion;
    private String age;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "structure")
    private List<Resource> resources = new ArrayList<>();
    
    private String build_time;
    private String hit_points;
    private String line_of_sight;
    private String armor;
    private String range;
    private String reload_time;
    private String attack;
    private String special;
    
    public void addResource(Resource resource) {
        resources.add(resource);
        resource.setStructure(this);
    }
    
    public void removeResource(Resource resource) {
        resources.remove(resource);
        resource.setStructure(null);
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Structure)) return false;
        return id != null && id.equals(((Structure) o).getId());
    }
    
    @Override
    public int hashCode() {
        return HashCodes.STRUCTURE;
    }
}   
