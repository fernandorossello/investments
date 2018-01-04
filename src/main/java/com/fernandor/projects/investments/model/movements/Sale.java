package com.fernandor.projects.investments.model.movements;

import com.fernandor.projects.investments.Exceptions.ZeroQuantityException;
import com.fernandor.projects.investments.model.OperationParameters;

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
