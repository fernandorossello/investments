package com.fernandor.projects.investments.model;

import com.fernandor.projects.investments.model.movements.Movement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public abstract class Investment {

    private int id;

    private List<Movement> movements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public double getBenefitPercentage(){
        throw new NotImplementedException();
    }

    public double getBenefitAmount(){
        throw  new NotImplementedException();
    }

    public double getCurrentUnitValue(){
        throw new NotImplementedException();
    }

    public double getCurrentQuantity(){
        throw new NotImplementedException();
    }

    public Movement buy(){
        throw new NotImplementedException();
    }

    public Movement sell(){
        throw new NotImplementedException();
    }

    public Movement collectDividends(){
        throw new NotImplementedException();
    }

}
