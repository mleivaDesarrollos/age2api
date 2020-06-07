/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service.impl;

import com.maximilianol.age2api.domain.Civilization;
import com.maximilianol.age2api.repository.CivilizationRepository;
import com.maximilianol.age2api.service.CivilizationService;
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
public class CivilizationServiceImpl implements CivilizationService {
    @Autowired
    private CivilizationRepository repository;
    
    @Override
    public Optional<Civilization> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public List<Civilization> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Civilization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Civilization save(Civilization civ) {
        return repository.save(civ);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    
}
