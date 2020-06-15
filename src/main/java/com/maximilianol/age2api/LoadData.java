/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api;

import com.maximilianol.age2api.domain.Civilization;
import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.domain.Technology;
import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.domain.adapter.CivilizationCsvAdapter;
import com.maximilianol.age2api.domain.adapter.StructureCsvAdapter;
import com.maximilianol.age2api.domain.adapter.TechnologyCsvAdapter;
import com.maximilianol.age2api.domain.adapter.UnitCsvAdapter;
import com.maximilianol.age2api.service.CivilizationService;
import com.maximilianol.age2api.service.StructureService;
import com.maximilianol.age2api.service.TechnologyService;
import com.maximilianol.age2api.service.UnitService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author zaktorius
 */
@Component
@Slf4j
public class LoadData {
    @Autowired
    private CivilizationService civService; 
    
    @Autowired
    private UnitService unitService;
    
    @Autowired
    private StructureService structureService;
    
    @Autowired
    private TechnologyService technologyService;
    
    @Bean
    public CommandLineRunner initDatabase() {
        return (args) -> {
            List<CivilizationCsvAdapter> civs = CsvReader.loadObjectList(CivilizationCsvAdapter.class, "civilizations.csv");
            List<UnitCsvAdapter> unitsCsv = CsvReader.loadObjectList(UnitCsvAdapter.class, "units.csv");
            List<StructureCsvAdapter> structureCsv = CsvReader.loadObjectList(StructureCsvAdapter.class, "structures.csv");
            List<TechnologyCsvAdapter> technologyCsv = CsvReader.loadObjectList(TechnologyCsvAdapter.class, "technologies.csv");
            List<Structure> structures = StructureCsvAdapter.toStructureList(structureCsv);
            
            structures.forEach(structure -> structureService.save(structure));
            List<Unit> units = UnitCsvAdapter.toUnitList(unitsCsv, structureService);
            List<Technology> technologies = TechnologyCsvAdapter.toTechnologyList(technologyCsv, structureService);
            units.forEach(unit -> unitService.save(unit));
            technologies.forEach(technology -> technologyService.save(technology));
            List<Civilization> civilizations = CivilizationCsvAdapter.toCivilizationList(civs, unitService);
            civilizations.forEach(civilization -> {
                civService.save(civilization);
            });
        };
    }
}
