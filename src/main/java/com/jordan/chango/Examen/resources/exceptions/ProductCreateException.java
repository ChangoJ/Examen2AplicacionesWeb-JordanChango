package com.jordan.chango.Examen.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductCreateException extends Exception{
    private static final long serialVersionUID = -7717691994704695707L;

    public ProductCreateException(String message){
        super(message);
    }
}
