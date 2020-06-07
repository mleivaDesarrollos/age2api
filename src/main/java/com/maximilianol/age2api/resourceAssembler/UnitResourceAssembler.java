/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler;

import com.maximilianol.age2api.controller.UnitController;
import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.resourceAssembler.model.UnitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author zaktorius
 */
@Component
public class UnitResourceAssembler extends RepresentationModelAssemblerSupport<Unit, UnitModel> {
    
    @Autowired
    private StructureResourceAssembler structureAssembler;
    
    public UnitResourceAssembler() {
        super(UnitController.class, UnitModel.class);
    }
    
    @Override
    public UnitModel toModel(Unit entity) {
        if(entity == null) return null;
        UnitModel unitModel = instantiateModel(entity);
        unitModel.add(linkTo(methodOn(UnitController.class).one(entity.getId())).withSelfRel());
        
        unitModel.setId(entity.getId());

        unitModel.setName(entity.getName());
        unitModel.setDescription(entity.getDescription());
        unitModel.setExpansion(entity.getExpansion());
        unitModel.setAge(entity.getAge());
        unitModel.setCreated_in(structureAssembler.toSimpleModel(entity.getCreated_in()));
        unitModel.setResources(ResourceResourceAssembler.toResourcesModel(entity.getResources()));
        unitModel.setBuild_time(entity.getBuild_time());
        unitModel.setReload_time(entity.getReload_time());
        unitModel.setAttack_delay(entity.getAttack_delay());
        unitModel.setMovement_rate(entity.getMovement_rate());
        unitModel.setLine_of_sight(entity.getLine_of_sight());
        unitModel.setHit_points(entity.getHit_points());
        unitModel.setRange(entity.getRange());
        unitModel.setAttack(entity.getAttack());
        unitModel.setArmor(entity.getArmor());
        unitModel.setAttack_bonus(entity.getAttack_bonus());
        unitModel.setArmor_bonus(entity.getArmor_bonus());
        unitModel.setSearch_radius(entity.getSearch_radius());
        unitModel.setAccuracy(entity.getAccuracy());
        unitModel.setBlast_radius(entity.getBlast_radius());
        return unitModel;
    }
    
    public UnitModel toSimpleModel(Unit entity) {
        if(entity == null) return null;
        UnitModel model = instantiateModel(entity);
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.add(linkTo(methodOn(UnitController.class).one(entity.getId())).withSelfRel());
        return model;
    }
    
    @Override
    public CollectionModel<UnitModel> toCollectionModel(Iterable <? extends Unit> units) {
        CollectionModel<UnitModel> unitsModel = super.toCollectionModel(units);
        unitsModel.add(linkTo(methodOn(UnitController.class).all()).withRel("units"));
        return unitsModel;
    }
    
}
