package mvc2;

/**
 *  The type Calculator model. The Model performs all the calculations needed and that is it. It doesn't know the View
 *  exists
 */
class CalculatorModel {

    // Holds the value of the sum of the numbers entered in the view
    private int calculationValue;

    /**
     * Add two numbers.
     *
     * @param firstNumber  the first number
     * @param secondNumber the second number
     */
    void addTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = firstNumber + secondNumber;
    }

    /**
     * Get calculation value int.
     *
     * @return the int
     */
    int getCalculationValue(){

        return calculationValue;
    }
}
