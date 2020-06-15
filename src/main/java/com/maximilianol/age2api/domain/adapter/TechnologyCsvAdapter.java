/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain.adapter;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.domain.Technology;
import com.maximilianol.age2api.service.StructureService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author zaktorius
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyCsvAdapter {
    private Long id;
    
    private String name;
    
    private String expansion;    
    private String age;
    
    private String develops_in;
    
    private String cost;
    
    private String build_time;
    
    private String applies_to;
    
    private String description;
    
    public static List<Technology> toTechnologyList(List<TechnologyCsvAdapter> techsCsv, StructureService stService) {
        if (techsCsv == null) return Collections.emptyList();
        List<Technology> techList = new ArrayList<>();
        for(TechnologyCsvAdapter techData : techsCsv) {
            String name = techData.getName().replaceAll("^\\s", "");
            String developsIn = techData.getDevelops_in().replaceAll("^\\s", "");
            
            Technology tech = new Technology();
            tech.setName(name);
            tech.setAge(techData.getAge());
            tech.setApplies_to(techData.getApplies_to());
            tech.setBuild_time(techData.getBuild_time());
            tech.setDescription(techData.getDescription());
            tech.setExpansion(techData.getExpansion());
            
            Structure structure = stService.findByNameExact(developsIn).orElse(null);
            tech.setDevelops_in(structure);
            
            List<Resource> resources = ResourceCsvAdapter.getResources(techData.getCost());
            resources.forEach(resource -> tech.addResource(resource));
            
            techList.add(tech);
        }
        return techList;
    }
    
}
