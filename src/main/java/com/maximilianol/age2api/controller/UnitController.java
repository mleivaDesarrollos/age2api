/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.controller;

import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.exception.UnitNotFoundException;
import com.maximilianol.age2api.resourceAssembler.UnitResourceAssembler;
import com.maximilianol.age2api.resourceAssembler.model.UnitModel;
import com.maximilianol.age2api.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zaktorius
 */
@RestController
@RequestMapping("/api/units")
public class UnitController {
    @Autowired
    private UnitService service;
    
    @Autowired
    private UnitResourceAssembler assembler;
    
    @GetMapping
    public ResponseEntity<CollectionModel<UnitModel>> all() {
        CollectionModel<UnitModel> unitsModel = assembler.toCollectionModel(service.findAll());
        return new ResponseEntity<>(unitsModel, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UnitModel> one(@PathVariable Long id) {
        UnitModel unitModel = assembler.toModel(service.findById(id).orElseThrow(() -> new UnitNotFoundException(id)));
        return new ResponseEntity<>(unitModel, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<UnitModel> newUnit(@RequestBody Unit unit) {
        Unit newUnit = service.save(unit);
        UnitModel unitModel = assembler.toModel(newUnit);
        return ResponseEntity
                .created(unitModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(unitModel);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UnitModel> updateUnit(@RequestBody Unit unit, @PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUnitById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
