
package com.fernandor.projects.investments;

import com.fernandor.projects.investments.model.Investment;
import com.fernandor.projects.investments.model.OperationParameters;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestmentOperationTests {

    Investment investment = new Investment() {};
    OperationParameters parametersPurchase = new OperationParameters();
    OperationParameters zeroQuantityParameters = new OperationParameters();


    @Before
    public void setUp(){
        parametersPurchase.setCommission(10);
        parametersPurchase.setDate(new DateTime());
        parametersPurchase.setQuantity(100);
        parametersPurchase.setUnitValue(15);

        zeroQuantityParameters.setQuantity(0);

    }

    @Test
    public void buyInvestmentIncreasesCurrentQuantity(){
        Assert.assertEquals(0,investment.getCurrentQuantity(),0);
        investment.buy(parametersPurchase);
        Assert.assertEquals(100,investment.getCurrentQuantity(),0);
    }

    @Test(expected = IllegalStateException.class)
    public void buyZeroUnitsThrowsException(){
        investment.buy(zeroQuantityParameters);
    }


}
