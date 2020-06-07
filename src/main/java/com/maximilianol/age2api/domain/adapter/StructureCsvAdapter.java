/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain.adapter;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.domain.Structure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zaktorius
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class StructureCsvAdapter {
    private Long id;
    
    private String name;
    private String expansion;
    private String age;
    
    private String cost;
    
    private String build_time;
    private String hit_points;
    private String line_of_sight;
    private String armor;
    private String range;
    private String reload_time;
    private String attack;
    private String special;
    
    public static List<Structure> toStructureList(List<StructureCsvAdapter> csvStructures) {
        if (csvStructures == null) return Collections.emptyList();
        List<Structure> structures = new ArrayList<>();
        
        for(StructureCsvAdapter csvStructure: csvStructures) {
            Structure structure = new Structure();
            String name = csvStructure.getName().replaceFirst("^\\s", "");
            structure.setId(csvStructure.getId());

            structure.setName(name);
            structure.setExpansion(csvStructure.getExpansion());
            structure.setAge(csvStructure.getAge());

            structure.setBuild_time(csvStructure.getBuild_time());
            structure.setHit_points(csvStructure.getHit_points());
            structure.setLine_of_sight(csvStructure.getLine_of_sight());
            structure.setArmor(csvStructure.getArmor());
            structure.setRange(csvStructure.getRange());
            structure.setReload_time(csvStructure.getReload_time());
            structure.setAttack(csvStructure.getAttack());
            structure.setSpecial(csvStructure.getSpecial());
            
            List<Resource> resources = ResourceCsvAdapter.getResources(csvStructure.getCost());
            resources.forEach(resource -> structure.addResource(resource));
            
            structures.add(structure);            
        }
        
        return structures;
    }
    
}
