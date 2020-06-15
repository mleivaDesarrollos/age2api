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
import javax.persistence.FetchType;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technology")
public class Technology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String expansion;    
    private String age;
    
    @ManyToOne (fetch = FetchType.LAZY)
    private Structure develops_in;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "technology")
    private List<Resource> resources = new ArrayList<>();
    
    private String build_time;
    
    private String applies_to;
    
    private String description;
    
    public void addResource(Resource resource) {
        this.getResources().add(resource);
        resource.setTechnology(this);
    }
    
    public void removeResource(Resource resource) {
        this.getResources().remove(resource);
        resource.setTechnology(null);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Technology)) return false;
        return id != null && id.equals(((Technology) o).getId());
    }
    
    @Override
    public int hashCode() {
        return HashCodes.TECHNOLOGY;
    }
}
