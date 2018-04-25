package eelab.mock.exercise7;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {

    @Mock
    private TraderRepository traderRepository;

    private TradeService tradeService;

    @Before
    public void setUp() {
        tradeService = new TradeService(traderRepository);
    }

    @Test
    public void testBuy() {

        int limit = 2;
        int stopLoss = 4;

        tradeService.buy(limit, stopLoss);

        // Il default è Mockito.eq
        BDDMockito.then(traderRepository).should().save(limit, stopLoss);
//        BDDMockito.then(traderRepository).should().save(Mockito.eq(limit), Mockito.eq(stopLoss));

//        Questo si romperà perchè quando si usano i matchers tutti gli argomenti devono usarli
//        BDDMockito.then(traderRepository).should().save(limit, Mockito.eq(stopLoss));
    }
}