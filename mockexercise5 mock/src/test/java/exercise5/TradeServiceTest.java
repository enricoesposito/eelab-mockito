package exercise5;


import com.sun.org.glassfish.gmbal.ManagedObject;
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

    @Mock
    private TradeRepository mockTradeRepository;

    @Mock
    private ReportValue dummyReportValue;

    @Mock
    private ReportService mockReportService;

    private String isin;

    private TradeService tradeService;

    @Before
    public void setUp(){

        tradeService = new TradeService(mockTradeRepository, mockReportService);
        isin = "EUR/USD";
    }

    // Stub variante responder
    @Test
    public void shouldReturnGiustoString()  {

        // Lo stub ci permette di impostare l'indirect input
        BDDMockito.given(mockTradeRepository.read(Mockito.anyString())).willReturn(0.1);
//        Mockito.when(stubTradeRepository.read(Mockito.anyString())).thenReturn(mockTradeResult);

        String result = tradeService.save(isin, dummyReportValue);

        Assert.assertEquals("Prezzo giusto", result);
        // Utilizzo il verify sul mock per l'indirect output
        BDDMockito.then(mockTradeRepository).should().read(Mockito.eq(isin));
        BDDMockito.then(mockReportService).should().save(Mockito.eq(dummyReportValue));
        Mockito.verify(mockReportService).save(Mockito.eq(dummyReportValue));
    }
}