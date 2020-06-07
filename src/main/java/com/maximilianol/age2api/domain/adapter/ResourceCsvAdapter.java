/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.domain.adapter;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.domain.ResourceType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zaktorius
 */
public class ResourceCsvAdapter {
    
    public static List<Resource> getResources(String cost) {
        List<Resource> resources = new ArrayList<>(); 
        String cleanText = "[\\s\\\"{}]";
        String costCleaned = cost.replaceAll(cleanText, "");
        String[] costSplitted = costCleaned.split(";");
        for(String singleResource : costSplitted) {
           Resource resource = new Resource();
           String[] resourceAndCost = singleResource.split(":");
           String resourceType = resourceAndCost[0].toUpperCase();
           String value = resourceAndCost[1];
           switch(resourceType) {
               case "FOOD":
                   resource.setType(ResourceType.FOOD);
                   break;
               case "STONE":
                   resource.setType(ResourceType.STONE);
                   break;
               case "WOOD":
                   resource.setType(ResourceType.WOOD);
                   break;
               case "GOLD":
                   resource.setType(ResourceType.GOLD);
                   break;
               default:
                   continue;
           }
           try {
               Integer intValue = Integer.parseInt(value);
               resource.setValue(intValue);
           } catch (NumberFormatException ex) {
               continue;
           }
           resources.add(resource);
        }
        return resources;
    }
    
}
