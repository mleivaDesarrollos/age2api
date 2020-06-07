/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service;

import com.maximilianol.age2api.domain.Structure;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author zaktorius
 */
public interface StructureService {
    Optional<Structure> findById(Long id);
    
    Structure findByName(String name);
    
    Optional<Structure> findByNameExact(String name);
    
    List<Structure> findAll();
    
    Page<Structure> findAll(Pageable pageable);
    
    Structure save(Structure structure);
    
    void deleteById(Long id);
    
}
