package behavorial.chain_of_responsibility;

/**
 * This object will contain 2 numbers and a calculation to perform in the form of a String.
 */
class Numbers {

    private int number1;
    private int number2;
    private String calculationWanted;

    /**
     *  Instantiates a new Numbers.
     *  @param newNumber1 a number.
     *  @param newNumber2 a number.
     *  @param calcWanted the calculationed wanted.
     */
    Numbers(int newNumber1, int newNumber2, String calcWanted){

        number1 = newNumber1;
        number2 = newNumber2;
        calculationWanted = calcWanted;
    }

    /**
     *  Get first int.
     *  @return the int
     */
    int getNumber1(){

        return number1;
    }

    /**
     *  Get second int.
     *  @return the int
     */
    int getNumber2(){

        return number2;
    }

    /**
     *  Get calculation wanted string.
     *  @return the string
     */
    String getCalcWanted(){

        return calculationWanted;
    }
}