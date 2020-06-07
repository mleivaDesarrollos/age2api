/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain.adapter;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.service.StructureService;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UnitCsvAdapter {
    private Long id;
    
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String created_in;
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
    
    public static List<Unit> toUnitList(List<UnitCsvAdapter> csvUnits, StructureService stService) {
        if (csvUnits == null) {
            return Collections.emptyList();
        }
        List<Unit> listUnits = new ArrayList<Unit>();
        
        for(UnitCsvAdapter unitCsv : csvUnits) {
            Unit unit = new Unit();
            String name = unitCsv.getName().replaceAll("^\\s", "");
            String created_in = unitCsv.getCreated_in().replaceAll("^\\s", "");
            
            unit.setId(unitCsv.getId());
            unit.setName(name);
            unit.setDescription(unitCsv.getDescription());
            unit.setExpansion(unitCsv.getExpansion());
            unit.setAge(unitCsv.getAge());
            unit.setBuild_time(unitCsv.getBuild_time());
            unit.setReload_time(unitCsv.getReload_time());
            unit.setAttack_delay(unitCsv.getAttack_delay());
            unit.setMovement_rate(unitCsv.getMovement_rate());
            unit.setLine_of_sight(unitCsv.getLine_of_sight());
            unit.setHit_points(unitCsv.getHit_points());
            unit.setRange(unitCsv.getRange());
            unit.setAttack(unitCsv.getAttack());
            unit.setArmor(unitCsv.getArmor());
            unit.setAttack_bonus(unitCsv.getAttack_bonus());
            unit.setArmor_bonus(unitCsv.getArmor_bonus());
            unit.setSearch_radius(unitCsv.getSearch_radius());
            unit.setAccuracy(unitCsv.getAccuracy());
            unit.setBlast_radius(unitCsv.getBlast_radius());
            
            Structure structure = stService.findByNameExact(created_in).orElse(null);
            unit.setCreated_in(structure);
            
            List<Resource> resources = ResourceCsvAdapter.getResources(unitCsv.getCost());
            resources.forEach(resource -> unit.addResource(resource));            
            
            listUnits.add(unit);
        }
        return listUnits;
    }
    
}
