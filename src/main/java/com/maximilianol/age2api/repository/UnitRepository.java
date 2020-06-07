/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.repository;

import com.maximilianol.age2api.domain.Unit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zaktorius
 */
public interface UnitRepository extends JpaRepository <Unit, Long> {
    Optional<Unit> findByNameContainingIgnoreCase(String name);
    
    Optional<Unit> findByNameIsIgnoreCase(String name);
    
    @Query("select u from Unit u where u.name like %?1%")
    Unit findByNameContainsIgnoreCase(String name);
}
