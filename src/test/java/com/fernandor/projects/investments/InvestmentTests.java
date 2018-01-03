package com.fernandor.projects.investments;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import com.fernandor.projects.investments.model.Investment;
import com.fernandor.projects.investments.model.movements.DividendsPayment;
import com.fernandor.projects.investments.model.movements.Movement;
import com.fernandor.projects.investments.model.movements.Purchase;
import com.fernandor.projects.investments.model.movements.Sale;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestmentTests {

    Investment investment= new Investment() {};
    Movement purchase = new Purchase();
    Movement sale = new Sale();
    Movement dividends = new DividendsPayment();


    @Before
    public void setUp() {

        purchase.setQuantity(100);
        purchase.setUnitValue(10);

        sale.setQuantity(50);
        sale.setUnitValue(110);


        dividends.setQuantity(20);
    }

    @After
    public void cleanUp(){
        investment.setMovements(new ArrayList<>());
    }

    @Test
    public void getCurrentQuantityWithoutMovementsReturnsZero(){
        Assert.assertEquals(0,investment.getCurrentQuantity(),0);
    }

    @Test
    public void getCurrentQuantityGetsCorrectSum(){
        investment.getMovements().add(purchase);
        investment.getMovements().add(sale);
        investment.getMovements().add(dividends);

        Assert.assertEquals(70,investment.getCurrentQuantity(),0);
    }

    @Test(expected = IllegalStateException.class)
    public void getCurrentQuantityThrowsExceptionIfNegative(){
        investment.getMovements().add(sale);
        investment.getCurrentQuantity();
    }

}
