package exercise4;

public class TradeService {

    private String greeting;

    // Attenzione con new qua non può funzionare
//    private TradeRepository tradeRepository = new TradeRepository();

    private TradeRepository tradeRepository;

    private ReportService reportService;

    public TradeService(TradeRepository tradeRepository,
                        ReportService reportService) {
        this.tradeRepository = tradeRepository;
        this.reportService = reportService;
    }

    public String save(String isin, ReportValue reportValue) {

        // Questa indirect input deve essere doppiato con uno stub
        Double aDouble = tradeRepository.read(isin);
        if(aDouble<0.1) {
            return "Troppo basso";
        } else if (aDouble==0.1) {
            reportService.save(reportValue);
            return "Prezzo giusto";
        } else {
            return "Troppo alto";
        }
    }
}
