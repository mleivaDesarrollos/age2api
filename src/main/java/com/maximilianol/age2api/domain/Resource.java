/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain;

import com.maximilianol.age2api.HashCodes;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private ResourceType type;
    
    private Integer value;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Unit unit;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structure;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Technology technology;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        return id != null && id.equals(((Resource) o).getId());
    }
    
    @Override
    public int hashCode() {
        return HashCodes.RESOURCE;
    }
}
