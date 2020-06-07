/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.repository;

import com.maximilianol.age2api.domain.Structure;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zaktorius
 */
public interface StructureRepository extends JpaRepository<Structure, Long> {
    Optional<Structure> findByNameContainingIgnoreCase(String name);
    
    Optional<Structure> findFirstByNameIsIgnoreCase(String name);
    
    @Query("select s from Structure s where s.name like %?1%")
    Structure findByNameContainsIgnoreCase(String name);
    
}
