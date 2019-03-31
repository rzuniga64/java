package behavorial.mediator;

/**
 *
 */
public class StockOffer{

    private int stockShares;
    private String stockSymbol;
    private int colleagueCode;

    /**
     *  Constructor.
     *  @param numOfShares number of shares.
     *  @param stock the stock.
     *  @param collCode colleague code.
     */
    public StockOffer(int numOfShares, String stock, int collCode){

        stockShares = numOfShares;
        stockSymbol = stock;
        colleagueCode = collCode;

    }

    /**
     *  getstockShares method.
     *  @return number of stock shares.
     */
    public int getstockShares() { return stockShares; }

    /**
     *  getStockSymbol method.
     *  @return stock symbol.
     */
    public String getStockSymbol() { return stockSymbol; }

    /**
     *  getCollcode method.
     *  @return colleague code.
     */
    public int getCollCode() { return colleagueCode; }
}
