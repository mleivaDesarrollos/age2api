/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain.adapter;

import com.maximilianol.age2api.domain.Civilization;
import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.service.UnitService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
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
@Slf4j
public class CivilizationCsvAdapter {
    private Long id;
    
    private String name;
    private String expansion;
    private String army_type;
    private String unique_unit;
    private String unique_tech;
    private String team_bonus;
    private String civilization_bonus;
    
    public static List<Civilization> toCivilizationList(List<CivilizationCsvAdapter> civsAdapter, UnitService unitService) {
        if (civsAdapter == null || unitService == null) {
            return Collections.emptyList();
        }
        List<Civilization> civList = new ArrayList<Civilization>(); 
        for(CivilizationCsvAdapter civAdapter: civsAdapter) {
            Civilization civ = new Civilization();
            String uniqueUnit = civAdapter.getUnique_unit().replaceFirst("^\\s", "");
            String name = civAdapter.getName().replaceFirst("^\\s", "");
            String expansion = civAdapter.getExpansion().replaceFirst("^\\s", "");
            String army_type = civAdapter.getArmy_type().replaceFirst("^\\s", "");
            String unique_tech = civAdapter.getUnique_tech().replaceFirst("^\\s", "");
            String team_bonus = civAdapter.getTeam_bonus().replaceFirst("^\\s", "");
            String civilization_bonus = civAdapter.getCivilization_bonus().replaceFirst("^\\s", "");
            civ.setId(civAdapter.getId());
            civ.setName(name);
            civ.setExpansion(expansion);
            civ.setArmy_type(army_type);
            civ.setUnique_tech(unique_tech);
            civ.setTeam_bonus(team_bonus);
            civ.setCivilization_bonus(civilization_bonus);
            Unit civUnit = unitService.findByNameExact(uniqueUnit).orElse(null);
            Unit civEliteUnit = unitService.findByName("Elite " + uniqueUnit);
            civ.setUniqueUnit(civUnit);
            civ.setUniqueEliteUnit(civEliteUnit);
            
            civList.add(civ);
        }
        return civList;
    } 
}
