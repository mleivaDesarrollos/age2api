/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 *
 * @author zaktorius
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "civilizations")
@JsonRootName("civilization")
@JsonInclude(Include.NON_NULL)
public class CivilizationModel extends RepresentationModel<CivilizationModel> {
    private Long id;
    
    private String name;
    private String expansion;
    private String army_type;
    private UnitModel uniqueUnit;
    private UnitModel uniqueEliteUnit;
    private String unique_tech;
    private String team_bonus;
    private String civilization_bonus;
    
}
