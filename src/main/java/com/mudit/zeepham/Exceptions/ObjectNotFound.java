package com.mudit.zeepham.Exceptions;

public class ObjectNotFound extends RuntimeException {
    @Override
    public String getMessage(){
        return "Object not found in DB";
    }
    
}
