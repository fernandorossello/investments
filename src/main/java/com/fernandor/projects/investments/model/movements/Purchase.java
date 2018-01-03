package com.fernandor.projects.investments.model.movements;

import com.fernandor.projects.investments.model.OperationParameters;

public class Purchase extends Movement {


    public Purchase(OperationParameters parameters) {
        super(parameters);
    }

    public Purchase() {
        super();
    }

    @Override
    public double getMoneyResult() {
        return -getAmount() - getCommission();
    }

    @Override
    public double getQuantityResult() {
        return getQuantity();
    }
}
