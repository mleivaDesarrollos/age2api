/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.repository;

import com.maximilianol.age2api.domain.Civilization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author zaktorius
 */
public interface CivilizationRepository extends JpaRepository<Civilization, Long> {
    
}
