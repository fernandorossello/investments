package com.fernandor.projects.investments.model.movements;

import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@DiscriminatorValue(value = "DIV")
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
