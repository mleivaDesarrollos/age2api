/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler;

import com.maximilianol.age2api.controller.TechnologyController;
import com.maximilianol.age2api.domain.Technology;
import com.maximilianol.age2api.resourceAssembler.model.TechnologyModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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
public class TechnologyResourceAssembler extends RepresentationModelAssemblerSupport<Technology, TechnologyModel> {
    @Autowired
    private StructureResourceAssembler structureAssembler;
    
    public TechnologyResourceAssembler() {
        super(TechnologyController.class, TechnologyModel.class);
    }
    
    public TechnologyModel toSimpleModel(Technology entity) {
        if (entity == null) return null;
        TechnologyModel model = instantiateModel(entity);
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.add(linkTo(methodOn(TechnologyController.class).one(entity.getId())).withSelfRel());
        return model;
    }

    @Override
    public TechnologyModel toModel(Technology entity) {
        if(entity == null) return null;
        TechnologyModel techModel = instantiateModel(entity);
        techModel.setId(entity.getId());
        techModel.setName(entity.getName());
        techModel.setExpansion(entity.getExpansion());
        techModel.setAge(entity.getAge());
        techModel.setDevelops_in(structureAssembler.toSimpleModel(entity.getDevelops_in()));

        techModel.setResources(ResourceResourceAssembler.toResourcesModel(entity.getResources()));

        techModel.setBuild_time(entity.getBuild_time());

        techModel.setApplies_to(entity.getApplies_to());

        techModel.setDescription(entity.getDescription());
        
        techModel.add(linkTo(methodOn(TechnologyController.class).one(entity.getId())).withSelfRel());
        return techModel;
    }
    
    public List<TechnologyModel> toSimpleSetModel(Set<Technology> technologies) {
        if (technologies == null) return Collections.emptyList();
        List<TechnologyModel> techsModel = new ArrayList<>();
        technologies.forEach(tech -> techsModel.add(toSimpleModel(tech)));
        return techsModel;        
    }
    
    @Override
    public CollectionModel<TechnologyModel> toCollectionModel(Iterable <? extends Technology> technologies) {
        CollectionModel<TechnologyModel> technologiesModel = super.toCollectionModel(technologies);
        technologiesModel.add(linkTo(methodOn(TechnologyController.class).all()).withSelfRel());
        return technologiesModel;
    }
    
}
