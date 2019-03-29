package behavorial.state;

/**
 * The type TestATMMachine.
 */
public class TestATMMachine {

    /**
     * Main.
     * @param args the args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args){

        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();
        atmMachine.ejectCard();
        atmMachine.insertCard();
        atmMachine.insertPin(1234);
        atmMachine.requestCash(2000);
        atmMachine.insertCard();
        atmMachine.insertPin(1234);
    }
}