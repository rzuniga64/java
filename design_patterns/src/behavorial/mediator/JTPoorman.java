package behavorial.mediator;

/**
 *  JTPoorman class.
 */
public class JTPoorman extends Colleague{

    /**
     *  Constructor.
     *  @param newMediator new Mediator.
     */
    public JTPoorman(Mediator newMediator) {

        super(newMediator);
        System.out.println("JT Poorman signed up with the stockexchange\n");
    }
}
