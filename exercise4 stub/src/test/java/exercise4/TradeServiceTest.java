package exercise4;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {

    public TradeServiceTest() {

    }

    @Mock
    private TradeRepository stubTradeRepository;

    @Mock
    private ReportValue dummyReportValue;

    private String isin;

    private TradeService tradeService;

    @Before
    public void setUp(){

        tradeService = new TradeService(stubTradeRepository, new ReportService());
        isin = "EUR/USD";
    }

    // Stub variante responder
    @Test
    public void shouldReturnGiustoString()  {

        // Lo stub ci permette di impostare l'indirect input
        BDDMockito.given(stubTradeRepository.read(Mockito.anyString())).willReturn(0.1);
//        Mockito.when(stubTradeRepository.read(Mockito.anyString())).thenReturn(0.1);

        // dummy object
        String result = tradeService.save(isin, dummyReportValue);
        //assert
        Assert.assertEquals("Prezzo giusto", result);
    }


    // Stub variante sabotateur
    @Test(expected = Exception.class)
    public void shouldThrowsException()  {

        // Impostiamo nello stub l'invio dell'eccezione
        BDDMockito.given(stubTradeRepository.read(Mockito.anyString())).willThrow(new Exception("Table  not found"));
//        Mockito.when(stubTradeRepository.read(Mockito.anyString())).thenThrow(new Exception("Table  not found"));

        // dummy object
        tradeService.save(isin, dummyReportValue);
    }
}