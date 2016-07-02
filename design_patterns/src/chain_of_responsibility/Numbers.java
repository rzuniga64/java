package chain_of_responsibility;

// This object will contain 2 numbers and a
// calculation to perform in the form of a String

class Numbers {

    private int number1;
    private int number2;

    private String calculationWanted;

    Numbers(int newNumber1, int newNumber2, String calcWanted){

        number1 = newNumber1;
        number2 = newNumber2;
        calculationWanted = calcWanted;
    }

    int getNumber1(){ return number1; }
    int getNumber2(){ return number2; }
    String getCalcWanted(){ return calculationWanted; }
}