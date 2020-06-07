/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service;

import com.maximilianol.age2api.domain.Unit;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author zaktorius
 */
public interface UnitService {
    Optional<Unit> findById(Long id);
    
    Unit findByName(String name);
    
    Optional<Unit> findByNameExact(String name);
    
    List<Unit> findAll();
    
    Page<Unit> findAll(Pageable pageable);
    
    Unit save(Unit unit);
    
    void deleteById(Long id);
    
}
