package eelab.mock.exercise7;

public class TradeService {

    private TraderRepository traderRepository;

    public TradeService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public void buy(int limit, int stopLoss) {
        traderRepository.save(limit, stopLoss);
    }

}
