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
public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException(Long id) {
        super("Could not find unit with id " + id);
    }
}
