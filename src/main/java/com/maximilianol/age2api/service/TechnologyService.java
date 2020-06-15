/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service;

import com.maximilianol.age2api.domain.Technology;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author zaktorius
 */
public interface TechnologyService {
    Optional<Technology> findById(Long id);
    
    Technology findByName(String name);
    
    Optional<Technology> findByNameExact(String name);
    
    List<Technology> findAll();
    
    Page<Technology> findAll(Pageable pageable);
    
    Technology save(Technology technology);
    
    void deleteById(Long id);
}
