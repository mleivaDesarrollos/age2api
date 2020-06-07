/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName("unit")
@Relation(collectionRelation = "units")
@JsonInclude(Include.NON_NULL)
public class UnitModel extends RepresentationModel<UnitModel> {
    private Long id;
    
    private String name;
    private String description;
    private String expansion;
    private String age;
    private StructureModel created_in;
    private List<ResourceModel> resources;
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
}
