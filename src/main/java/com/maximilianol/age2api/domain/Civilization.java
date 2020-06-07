/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author zaktorius
 */
@Data
@Entity
@Table(name = "civilization")
@AllArgsConstructor
@NoArgsConstructor
public class Civilization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String expansion;
    private String army_type;
    
    @ManyToOne
    private Unit uniqueUnit;
    @ManyToOne
    private Unit uniqueEliteUnit;
    
    private String unique_tech;
    private String team_bonus;
    private String civilization_bonus;
}
