package behavorial.mediator;

/**
 *  Colleague class.
 */
public abstract class Colleague{

    private Mediator mediator;
    private int colleagueCode;

    /**
     *
     *  @param newMediator
     */
    public Colleague(Mediator newMediator){

        mediator = newMediator;
        mediator.addColleague(this);
    }

    /**
     *  saleOffer method.
     *  @param stock the stock.
     *  @param shares the number of shares of stock.
     */
    public void saleOffer(String stock, int shares){

        mediator.saleOffer(stock, shares, this.colleagueCode);

    }

    /**
     *  buyOffer method.
     *  @param stock the stock.
     *  @param shares the number of shares of stock.
     */
    public void buyOffer(String stock, int shares){

        mediator.buyOffer(stock, shares, this.colleagueCode);
    }

    /**
     *  setCollCode method.
     *  @param collCode new colleague code.
     */
    public void setCollCode(int collCode){ colleagueCode = collCode; }
}
