package com.fernandor.projects.investments.Exceptions;

public class NotEnoughQuantityException extends Exception {

    public NotEnoughQuantityException(double currentQuantity,double operationQuantity){
        super("No se puede realizar la operación ya que la tenencia actual (" + currentQuantity +
                ") no cubre lo solicitado por la operación (" + operationQuantity + ")" );
    }
}
