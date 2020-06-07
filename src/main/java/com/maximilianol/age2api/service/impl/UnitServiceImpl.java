/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service.impl;

import com.maximilianol.age2api.domain.Unit;
import com.maximilianol.age2api.repository.UnitRepository;
import com.maximilianol.age2api.service.UnitService;
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
public class UnitServiceImpl implements UnitService{

    @Autowired
    private UnitRepository repository;
    
    @Override
    public Optional<Unit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Unit> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Unit save(Unit unit) {
        return repository.save(unit);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Unit findByName(String name) {
        return repository.findByNameContainsIgnoreCase(name);
   }

    @Override
    public Optional<Unit> findByNameExact(String name) {
        return repository.findByNameIsIgnoreCase(name);
    }
    
    
}
