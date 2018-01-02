package com.fernandor.projects.investments.model.movements;

public class DividendsPayment extends Movement {
    @Override
    public double getMoneyResult() {
        return 0;
    }

    @Override
    public double getQuantityResult() {
        return getQuantity();
    }
}
