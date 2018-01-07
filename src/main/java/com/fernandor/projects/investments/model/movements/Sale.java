package com.fernandor.projects.investments.model.movements;

import com.fernandor.projects.investments.Exceptions.ZeroQuantityException;
import com.fernandor.projects.investments.model.OperationParameters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@DiscriminatorValue(value = "SAL")
public class Sale extends Movement {

    public Sale(OperationParameters parameters) throws ZeroQuantityException {
        super(parameters);

        parameters.validateQuantity();
    }

    public Sale() {
        super();
    }

    @Override
    public double getMoneyResult() {
        return getAmount() - getCommission();
    }

    @Override
    public double getQuantityResult() {
        return -getQuantity();
    }
}
