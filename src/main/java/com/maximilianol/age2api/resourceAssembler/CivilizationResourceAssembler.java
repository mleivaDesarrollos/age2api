/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler;

import com.maximilianol.age2api.controller.CivilizationController;
import com.maximilianol.age2api.domain.Civilization;
import com.maximilianol.age2api.resourceAssembler.model.CivilizationModel;
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
public class CivilizationResourceAssembler extends RepresentationModelAssemblerSupport<Civilization, CivilizationModel> {
    
    @Autowired
    private UnitResourceAssembler unitAssembler;
    
    public CivilizationResourceAssembler() {
        super(CivilizationController.class, CivilizationModel.class);
    }

    @Override
    public CivilizationModel toModel(Civilization entity) {
        if (entity == null) return null;
        CivilizationModel civModel = instantiateModel(entity);
        civModel.setId(entity.getId());
        civModel.setName(entity.getName());
        civModel.setExpansion(entity.getExpansion());
        civModel.setArmy_type(entity.getArmy_type());
        civModel.setUniqueUnit(unitAssembler.toSimpleModel(entity.getUniqueUnit()));
        civModel.setUniqueEliteUnit(unitAssembler.toSimpleModel(entity.getUniqueEliteUnit()));
        civModel.setUnique_tech(entity.getUnique_tech());
        civModel.setTeam_bonus(entity.getTeam_bonus());
        civModel.setCivilization_bonus(entity.getCivilization_bonus());
        civModel.add(linkTo(methodOn(CivilizationController.class).one(entity.getId())).withSelfRel());
        return civModel;
    }
    
    @Override
    public CollectionModel<CivilizationModel> toCollectionModel(Iterable <? extends Civilization> civilizations) {
        CollectionModel<CivilizationModel> civilizationsModel = super.toCollectionModel(civilizations);
        civilizationsModel.add(linkTo(methodOn(CivilizationController.class).all()).withRel("civilizations"));
        return civilizationsModel;
    }
    
}
