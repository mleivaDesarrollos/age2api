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
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 *
 * @author zaktorius
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("technology")
@Relation(collectionRelation="technologies")
@JsonInclude(Include.NON_NULL)
public class TechnologyModel extends RepresentationModel<TechnologyModel> {
    private Long id;
    
    private String name;
    
    private String expansion;    
    private String age;
    
    private StructureModel develops_in;
    
    private List<ResourceModel> resources;
    
    private String build_time;
    
    private String applies_to;
    
    private String description;
    
}
