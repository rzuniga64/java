package behavorial.chain_of_responsibility;

/**
 * This object will contain 2 numbers and a calculation to perform in the form of a String
 */
public class AddNumbers implements Chain{

    private  Chain nextInChain;

    /**
     * Defines the next Object to receive the data if this one can't use it
     */
    public void setNextChain(Chain nextChain) {

        nextInChain = nextChain;
    }

    /**
     * Tries to calculate the data, or passes it to the Object defined in method setNextChain()
     */
    public void calculate(Numbers request) {

        if(request.getCalcWanted().equals("add")) {

            System.out.print(
                    request.getNumber1()
                    + " + "
                    + request.getNumber2()
                    + " = "
                    + (request.getNumber1() + request.getNumber2())
            );
        }
        else
            nextInChain.calculate(request);
    }
}