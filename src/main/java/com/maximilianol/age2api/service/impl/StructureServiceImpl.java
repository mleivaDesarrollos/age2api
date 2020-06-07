/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service.impl;

import com.maximilianol.age2api.domain.Structure;
import com.maximilianol.age2api.repository.StructureRepository;
import com.maximilianol.age2api.service.StructureService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

/**
 *
 * @author zaktorius
 */
@Service
@Transactional
public class StructureServiceImpl implements StructureService {
    @Autowired
    private StructureRepository repository;
    
    @Override
    public Optional<Structure> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Structure findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).orElse(null);
    }

    @Override
    public Optional<Structure> findByNameExact(String name) {
        return repository.findFirstByNameIsIgnoreCase(name);
    }

    @Override
    public List<Structure> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Structure> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Structure save(Structure structure) {
        return repository.save(structure);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
