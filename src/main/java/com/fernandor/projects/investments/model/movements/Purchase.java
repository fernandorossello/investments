package com.fernandor.projects.investments.model.movements;

public class Purchase extends Movement {
    @Override
    public double getMoneyResult() {
        return -getAmount() - getCommission();
    }

    @Override
    public double getQuantityResult() {
        return getQuantity();
    }
}
