package com.fernandor.projects.investments.model.movements;

import com.fernandor.projects.investments.model.Currency;
import com.fernandor.projects.investments.model.Investment;
import org.joda.time.DateTime;


public abstract class Movement {

    private Investment investment;

    private DateTime date;

    private double unitValue;

    private Currency currency;

    private double quantity;

    private double commission;

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
