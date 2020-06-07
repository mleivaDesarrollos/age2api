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
public class CivilizationNotFoundException extends RuntimeException{
    public CivilizationNotFoundException(Long id) {
        super("Could not find civilization with " + id);
    }
}
