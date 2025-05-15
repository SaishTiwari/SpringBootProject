package com.myfirstproject.productlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{

    public CategoryAlreadyExistException(String message) {
        super(message);
    }

}
