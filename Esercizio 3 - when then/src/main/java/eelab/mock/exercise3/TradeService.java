package eelab.mock.exercise3;

public class TradeService {

    private String greeting;

    private TradeRepository tradeRepository = new TradeRepository();

    private ReportService reportService;

    public TradeService(ReportService reportService) {
        this.reportService = reportService;
    }

    public TradeService(TradeRepository tradeRepository,
                        ReportService reportService) {
        this.tradeRepository = tradeRepository;
        this.reportService = reportService;
    }


    public String save(ReportValue reportValue) {

        reportService.save(reportValue);
        return "Prezzo giusto";
    }
}
