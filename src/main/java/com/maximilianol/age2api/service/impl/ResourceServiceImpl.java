/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.service.impl;

import com.maximilianol.age2api.domain.Resource;
import com.maximilianol.age2api.repository.ResourceRepository;
import com.maximilianol.age2api.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository repository;

    @Override
    public Optional<Resource> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Resource> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Resource> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Resource save(Resource resource) {
        return repository.save(resource);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
