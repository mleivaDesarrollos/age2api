/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service;

import com.maximilianol.age2api.domain.Resource;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author zaktorius
 */
public interface ResourceService {
    Optional<Resource> findById(Long id);
    
    List<Resource> findAll();
    
    Page<Resource> findAll(Pageable pageable);
    
    Resource save(Resource resource);
    
    void deleteById(Long id);
    
}
