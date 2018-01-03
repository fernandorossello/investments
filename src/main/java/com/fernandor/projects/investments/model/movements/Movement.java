package com.fernandor.projects.investments.model.movements;

import com.fernandor.projects.investments.model.Investment;
import com.fernandor.projects.investments.model.OperationParameters;
import org.joda.time.DateTime;


public abstract class Movement {

    private Investment investment;

    private DateTime date;

    private double unitValue;

    private double quantity;

    private double commission;

    public Movement(OperationParameters parameters) {
        this();

        this.setQuantity(parameters.getQuantity());
        this.setUnitValue(parameters.getUnitValue());
        this.setCommission(parameters.getCommission());
        this.setDate(parameters.getDate());
    }

    public Movement() {}

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

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

    //Returns net money amount of the movement
    public double getAmount(){
        return unitValue * quantity;
    }

    public abstract double getMoneyResult();

    public abstract double getQuantityResult();

}
