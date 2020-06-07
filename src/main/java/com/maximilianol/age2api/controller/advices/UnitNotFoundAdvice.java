/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api.controller.advices;

import com.maximilianol.age2api.exception.UnitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author zaktorius
 */
@ControllerAdvice
public class UnitNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(UnitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String unitNotFoundMessage(UnitNotFoundException ex) {
        return ex.getMessage();
    }
}
