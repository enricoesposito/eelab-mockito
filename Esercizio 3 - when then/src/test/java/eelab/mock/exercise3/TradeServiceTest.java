package eelab.mock.exercise3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {

    public TradeServiceTest() {

    }

    @Mock
    private ReportValue reportValue;

    private TradeService tradeService;

    @Before
    public void setUp(){

        tradeService = new TradeService(new ReportService());
    }

    @Test
    public void shouldReturnGiustoString()  {

        // Without mockito
//        Trader trader = new Trader();
//        ReportValue reportValue = new ReportValue();
//        reportValue.setTraderName(trader);

        // dummy object
        String result = tradeService.save(reportValue);
        //assert
        Assert.assertEquals("Prezzo giusto", result);
    }
}