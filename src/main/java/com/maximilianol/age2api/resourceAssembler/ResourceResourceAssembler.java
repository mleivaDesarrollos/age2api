/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.resourceAssembler;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.resourceAssembler.model.ResourceModel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zaktorius
 */
public class ResourceResourceAssembler {
    public static List<ResourceModel> toResourcesModel(List<Resource> resources) {
        if(resources == null) {
            return Collections.emptyList();
        }
        return resources.stream()
                .map(resource -> ResourceModel.builder()
                        .type(resource.getType())
                        .value(resource.getValue())
                        .build()
                ).collect(Collectors.toList());
    }
}
