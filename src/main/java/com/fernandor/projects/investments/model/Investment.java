package com.fernandor.projects.investments.model;

import com.fernandor.projects.investments.Exceptions.NotEnoughQuantityException;
import com.fernandor.projects.investments.Exceptions.ZeroQuantityException;
import com.fernandor.projects.investments.model.movements.Movement;
import com.fernandor.projects.investments.model.movements.Purchase;
import com.fernandor.projects.investments.model.movements.Sale;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public abstract class Investment {

    public Investment(){
        if(this.movements == null){
            this.movements = new ArrayList<>();
        }
    }

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

    protected void addMovement(Movement movement){
        this.getMovements().add(movement);
    };

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

        double sum = 0;

        for (Movement movement : this.getMovements()) {
            sum = sum + movement.getQuantityResult();
        }

        if(sum < 0){
            String message ="Current quantity can't be negative. Result: " + sum;
            throw new IllegalStateException(message);
        }

        return sum;
    }

    public Movement buy(OperationParameters parameters) throws ZeroQuantityException {

        Movement purchase =  new Purchase(parameters);
        this.addMovement(purchase);

        return purchase;
    }



    public Movement sell(OperationParameters parameters) throws NotEnoughQuantityException, ZeroQuantityException {

        Movement sale = new Sale(parameters);

        this.validateEnoughQuantity(parameters.getQuantity());

        this.addMovement(sale);

        return sale;
    }

    protected void validateEnoughQuantity(double quantity) throws NotEnoughQuantityException{
        if(getCurrentQuantity() < quantity){
            throw new NotEnoughQuantityException(getCurrentQuantity(),quantity);
        }
    }

    public Movement collectDividends(OperationParameters parameters){
        throw new NotImplementedException();
    }



}
