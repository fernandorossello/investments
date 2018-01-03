package com.fernandor.projects.investments.model.movements;

public class Sale extends Movement {
    @Override
    public double getMoneyResult() {
        return getAmount() - getCommission();
    }

    @Override
    public double getQuantityResult() {
        return -getQuantity();
    }
}
