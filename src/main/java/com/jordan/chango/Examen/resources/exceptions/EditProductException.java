package com.jordan.chango.Examen.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EditProductException extends Exception{
    private static final long serialVersionUID = -7717691994704695707L;

    public EditProductException(String message){
        super(message);
    }
}
