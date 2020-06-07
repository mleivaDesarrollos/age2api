/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler;

import com.maximilianol.age2api.controller.StructureController;
import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.resourceAssembler.model.StructureModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author zaktorius
 */
@Component
public class StructureResourceAssembler extends RepresentationModelAssemblerSupport<Structure, StructureModel>{
    public StructureResourceAssembler() {
        super(StructureController.class, StructureModel.class);
    }

    @Override
    public StructureModel toModel(Structure entity) {
        if (entity == null) return null;
        StructureModel model = instantiateModel(entity);
        
        model.setId(entity.getId());

        model.setName(entity.getName());
        model.setExpansion(entity.getExpansion());
        model.setAge(entity.getAge());

        model.setResources(ResourceResourceAssembler.toResourcesModel(entity.getResources()));

        model.setBuild_time(entity.getBuild_time());
        model.setHit_points(entity.getHit_points());
        model.setLine_of_sight(entity.getLine_of_sight());
        model.setArmor(entity.getArmor());
        model.setRange(entity.getRange());
        model.setReload_time(entity.getReload_time());
        model.setAttack(entity.getAttack());
        model.setSpecial(entity.getSpecial());
        model.add(linkTo(methodOn(StructureController.class).one(entity.getId())).withSelfRel());
        return model;
    }
    
    public StructureModel toSimpleModel(Structure entity) {
        if(entity == null) return null;
        StructureModel model = instantiateModel(entity);
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.add(linkTo(methodOn(StructureController.class).one(entity.getId())).withSelfRel());
        return model;
    }
    
    @Override
    public CollectionModel<StructureModel> toCollectionModel(Iterable <? extends Structure> structures) {
        CollectionModel<StructureModel> structuresModel = super.toCollectionModel(structures);
        structuresModel.add(linkTo(methodOn(StructureController.class).all()).withSelfRel());
        return structuresModel;
    }
    
    
    
}
