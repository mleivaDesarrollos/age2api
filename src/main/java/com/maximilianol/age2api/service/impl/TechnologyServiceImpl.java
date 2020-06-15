/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service.impl;

import com.maximilianol.age2api.domain.Technology;
import com.maximilianol.age2api.repository.TechnologyRepository;
import com.maximilianol.age2api.service.TechnologyService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author zaktorius
 */
@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository repository;
    

    @Override
    public Technology findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).orElse(null);
    }

    @Override
    public Optional<Technology> findByNameExact(String name) {
        return repository.findFirstByNameIsIgnoreCase(name);
    }

    @Override
    public List<Technology> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Technology> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Technology save(Technology technology) {
        return repository.save(technology);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public Optional<Technology> findById(Long id) {
        return repository.findById(id);
    }
    
}
