package org.saurabhsood.controllers.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Keyword")
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String key){
        super(key+" not available");
    }
}