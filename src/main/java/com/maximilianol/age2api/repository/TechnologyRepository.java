/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.repository;

import com.maximilianol.age2api.domain.Technology;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zaktorius
 */

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    Optional<Technology> findByNameContainingIgnoreCase(String name);
    
    Optional<Technology> findFirstByNameIsIgnoreCase(String name);
    
    @Query("select t from Technology t where t.name like %?1%")
    Technology findByNameContainsIgnoreCase(String name);
    
    
}
