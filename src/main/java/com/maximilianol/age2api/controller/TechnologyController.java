/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.controller;

import com.maximilianol.age2api.domain.Technology;
import com.maximilianol.age2api.exception.TechnologyNotFoundException;
import com.maximilianol.age2api.resourceAssembler.TechnologyResourceAssembler;
import com.maximilianol.age2api.resourceAssembler.model.TechnologyModel;
import com.maximilianol.age2api.service.TechnologyService;
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
@RequestMapping("/api/technologies")
public class TechnologyController {
    @Autowired
    private TechnologyService service;
    
    @Autowired
    private TechnologyResourceAssembler assembler;
    
    @GetMapping
    public ResponseEntity<CollectionModel<TechnologyModel>> all() {
        CollectionModel<TechnologyModel> techModels = assembler.toCollectionModel(service.findAll());
        return new ResponseEntity<>(techModels, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TechnologyModel> one(@PathVariable Long id){
        TechnologyModel tech = assembler.toModel(service.findById(id).orElseThrow(() -> new TechnologyNotFoundException(id)));
        return new ResponseEntity(tech, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> newTechnology(@RequestBody Technology technology) {
        Technology tech = service.save(technology);
        TechnologyModel techModel = assembler.toModel(tech);
        return ResponseEntity
                .created(techModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(techModel);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTechnology(@RequestBody Technology technology, @PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
