
package com.fernandor.projects.investments;

import com.fernandor.projects.investments.Exceptions.NotEnoughQuantityException;
import com.fernandor.projects.investments.Exceptions.ZeroQuantityException;
import com.fernandor.projects.investments.model.Investment;
import com.fernandor.projects.investments.model.OperationParameters;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestmentOperationTests {

    Investment investment = new Investment() {};
    OperationParameters purchaseParameters = new OperationParameters();
    OperationParameters zeroQuantityParameters = new OperationParameters();
    OperationParameters saleParameters = new OperationParameters();


    @Before
    public void setUp(){
        purchaseParameters.setCommission(10);
        purchaseParameters.setQuantity(100);
        purchaseParameters.setUnitValue(15);

        zeroQuantityParameters.setQuantity(0);

        saleParameters.setCommission(10);
        saleParameters.setQuantity(60);
        saleParameters.setUnitValue(16);

    }

    @After
    public void cleanUp(){
        investment.setMovements(new ArrayList<>());
    }

    @Test
    public void buyInvestmentIncreasesCurrentQuantity() throws ZeroQuantityException {
        Assert.assertEquals(0,investment.getCurrentQuantity(),0);
        investment.buy(purchaseParameters);
        Assert.assertEquals(100,investment.getCurrentQuantity(),0);
    }

    @Test(expected = ZeroQuantityException.class)
    public void buyZeroUnitsThrowsException() throws ZeroQuantityException {
        investment.buy(zeroQuantityParameters);
    }

    @Test(expected = ZeroQuantityException.class)
    public void sellZeroUnitsThrowsException() throws NotEnoughQuantityException, ZeroQuantityException {
        investment.sell(zeroQuantityParameters);
    }

    @Test(expected = NotEnoughQuantityException.class)
    public void cantSellWithoutBuying() throws NotEnoughQuantityException, ZeroQuantityException {
        investment.sell(saleParameters);
    }

    @Test(expected = NotEnoughQuantityException.class)
    public void ifSaleIsGreaterThanWhatIHaveThrowsException() throws ZeroQuantityException, NotEnoughQuantityException {
        investment.buy(purchaseParameters);
        investment.sell(saleParameters);

        investment.sell(saleParameters);
    }

    @Test
    public void correctQuantityAfterSelling() throws NotEnoughQuantityException, ZeroQuantityException {
        investment.buy(purchaseParameters);
        investment.sell(saleParameters);

        Assert.assertEquals(40,investment.getCurrentQuantity(),0);
    }




}
