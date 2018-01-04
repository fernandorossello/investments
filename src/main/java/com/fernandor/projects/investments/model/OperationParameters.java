package com.fernandor.projects.investments.model;

import com.fernandor.projects.investments.Exceptions.ZeroQuantityException;
import org.joda.time.DateTime;

public class OperationParameters {

    private DateTime date;

    private double unitValue;

    private double quantity;

    private double commission;

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void validateQuantity() throws ZeroQuantityException {
        if(this.getQuantity() == 0){
            throw new ZeroQuantityException();
        }
    }
}
