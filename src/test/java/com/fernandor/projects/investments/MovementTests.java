package com.fernandor.projects.investments;

import com.fernandor.projects.investments.model.movements.DividendsPayment;
import com.fernandor.projects.investments.model.movements.Movement;
import com.fernandor.projects.investments.model.movements.Purchase;
import com.fernandor.projects.investments.model.movements.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovementTests {

    Movement sale = new Sale();
    Movement dividends = new DividendsPayment();
    Movement purchase = new Purchase();

    @Before
    public void setUp(){
        sale.setQuantity(100);
        sale.setUnitValue(10);

        purchase.setQuantity(500);
        purchase.setUnitValue(5);

        dividends.setQuantity(200);
    }

    @Test
    public void saleReturnsNegativeQuantity(){
        Assert.assertEquals(-100,sale.getQuantityResult(),0);
    }

    @Test
    public void saleReturnsPositiveMoneyResult(){
        Assert.assertEquals(1000,sale.getMoneyResult(),0);
    }

    @Test
    public void purchaseReturnsPositiveQuantity(){
        Assert.assertEquals(500,purchase.getQuantityResult(),0);
    }

    @Test
    public void purchaseReturnsNegativeMoneyResult(){
        Assert.assertEquals(-2500,purchase.getMoneyResult(),0);
    }

    @Test
    public void dividendsReturnsZeroMoneyResult(){
        Assert.assertEquals(0,dividends.getMoneyResult(),0);
    }

    @Test
    public void dividendsReturnPositiveQuantity(){
        Assert.assertEquals(200,dividends.getQuantityResult(),0);
    }

}
