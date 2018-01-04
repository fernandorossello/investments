package com.fernandor.projects.investments.Exceptions;

public class ZeroQuantityException extends Exception {

    public ZeroQuantityException(){
        super("No se pueden operar por 0 unidades");
    }
}
