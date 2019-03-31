package behavorial.mediator;

/**
 *  Mediator interface.
 */
public interface Mediator {

    /**
     *  saleOffer method.
     *  @param stock the stock.
     *  @param shares the number of stock shares.
     *  @param collCode the colleague code.
     */
    public void saleOffer(String stock, int shares, int collCode);

    /**
     *  buyOffer method.
     *  @param stock the stock.
     *  @param shares the number of stock shares.
     *  @param collCode the colleague code.
     */
    public void buyOffer(String stock, int shares, int collCode);

    /**
     *  addColleague method.
     * @param colleague the colleague.
     */
    public void addColleague(Colleague colleague);
}
