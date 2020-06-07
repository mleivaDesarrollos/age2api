/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service;

import com.maximilianol.age2api.domain.Civilization;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 *
 * @author zaktorius
 */
public interface CivilizationService {
    Optional<Civilization> findById(Long id);
    
    List<Civilization> findAll();
    
    Page<Civilization> findAll(Pageable pageable);
    
    Civilization save(Civilization civ);
    
    void deleteById(Long id);
}
