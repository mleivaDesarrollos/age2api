/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.controller;

import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.exception.StructureNotFoundException;
import com.maximilianol.age2api.resourceAssembler.StructureResourceAssembler;
import com.maximilianol.age2api.resourceAssembler.model.StructureModel;
import com.maximilianol.age2api.service.StructureService;
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
@RequestMapping("/api/structures")
public class StructureController {
    @Autowired
    private StructureService service;
    
    @Autowired
    private StructureResourceAssembler assembler;
    
    @GetMapping
    public ResponseEntity<CollectionModel<StructureModel>> all() {
        CollectionModel<StructureModel> structuresModel = assembler.toCollectionModel(service.findAll());
        return new ResponseEntity<>(structuresModel, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        StructureModel structureModel = assembler.toModel(service.findById(id).orElseThrow(() -> new StructureNotFoundException(id)));
        return new ResponseEntity<>(structureModel, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> newStructure(@RequestBody Structure structure) {
        Structure newStructure = service.save(structure);
        StructureModel structureModel = assembler.toModel(newStructure);
        return ResponseEntity
                .created(structureModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(structureModel);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStructure(@RequestBody Structure structure) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStructureById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
