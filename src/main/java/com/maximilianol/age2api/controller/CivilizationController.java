/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.controller;

import com.maximilianol.age2api.domain.Civilization;
import com.maximilianol.age2api.exception.CivilizationNotFoundException;
import com.maximilianol.age2api.resourceAssembler.model.CivilizationModel;
import com.maximilianol.age2api.resourceAssembler.CivilizationResourceAssembler;
import com.maximilianol.age2api.service.CivilizationService;
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
@RequestMapping("/api/civilizations")
public class CivilizationController {
    @Autowired
    private CivilizationService service;
    @Autowired
    private CivilizationResourceAssembler assembler;
    
    @GetMapping
    public ResponseEntity<CollectionModel<CivilizationModel>> all() {
        CollectionModel<CivilizationModel> civsModel = assembler.toCollectionModel(service.findAll());
        return new ResponseEntity<>(civsModel, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CivilizationModel> one(@PathVariable Long id) {
        CivilizationModel civModel = assembler.toModel(service.findById(id).orElseThrow(() -> new CivilizationNotFoundException(id)));
        return new ResponseEntity<>(civModel, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CivilizationModel> newCiv(@RequestBody Civilization civ) {
        Civilization newCiv = service.save(civ);
        CivilizationModel civModel = assembler.toModel(newCiv);
        return ResponseEntity
                .created(civModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(civModel);
    }
    
    @PutMapping("/{id}")
    public Civilization replaceCiv(@RequestBody Civilization civ, @PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
