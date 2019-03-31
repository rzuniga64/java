package behavorial.mediator;

/**
 *  GormanSlacks method.
 */
public class GormanSlacks extends Colleague{

    /**
     *  Constructor.
     *  @param newMediator new Mediator.
     */
    public GormanSlacks(Mediator newMediator) {

        super(newMediator);
        System.out.println("Gorman Slacks signed up with the stockexchange\n");
    }
}