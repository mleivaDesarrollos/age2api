/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.exception;

/**
 *
 * @author zaktorius
 */
public class TechnologyNotFoundException extends RuntimeException {
    public TechnologyNotFoundException(Long id) {
        super("Could not find technolgy with id " + id);
    }
    
    public TechnologyNotFoundException(String name) {
        super("Could not find technology with name " + name);
    }
}
