package com.shiju.catalog_service.exceptions;

public class CatalogException extends RuntimeException{

    public CatalogException(String message, Throwable t){
        super(message, t);
    }


}
