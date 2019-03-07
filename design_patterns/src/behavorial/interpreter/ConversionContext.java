package behavorial.interpreter;

/**
 * The type ConversionContext.
 */
class ConversionContext {

    private String conversionQues = "";
    private String conversionResponse = "";
    private String fromConversion = "";
    private String toConversion = "";
    private double quantity;

    /**
     * Instantiates a new Conversion context.
     * @param input the input
     */
    ConversionContext(String input)
    {
        String[] partsOfQues;

        this.conversionQues = input;
        partsOfQues = getInput().split(" ");
        fromConversion = getCapitalized(partsOfQues[1]);
        toConversion = getCapitalized(getLowercase(partsOfQues[3])); // 1 gallon to pints
        quantity = Double.valueOf(partsOfQues[0]);
        conversionResponse = partsOfQues[0] + " "+ partsOfQues[1] + " equals ";
    }

    /**
     *  Get input.
     *  @return
     */
    private String getInput() {

        return conversionQues;
    }

    /**
     * Gets from conversion.
     * @return the from conversion
     */
    String getFromConversion() {

        return fromConversion;
    }

    /**
     * Gets to conversion.
     * @return the to conversion
     */
    String getToConversion() {

        return toConversion;
    }

    /**
     * Gets response.
     * @return the response
     */
    String getResponse() {

        return conversionResponse;
    }

    /**
     * Gets quantity.
     * @return the quantity
     */
    double getQuantity() {

        return quantity;
    }

    /**
     * Make String lowercase
     * @return the words in lowercase
     */
    String getLowercase(String wordToLowercase){

        return wordToLowercase.toLowerCase();
    }

    /**
     * Capitalizes the first letter of a group of words
     * @return the group of words with first letter capitalized.
     */
    private String getCapitalized(String wordToCapitalize){

        // Make characters lower case
        wordToCapitalize = wordToCapitalize.toLowerCase();

        // Make the first character uppercase
        wordToCapitalize = Character.toUpperCase(wordToCapitalize.charAt(0)) + wordToCapitalize.substring(1);

        // Put s on the end if not there
        int lengthOfWord = wordToCapitalize.length();

        if((wordToCapitalize.charAt(lengthOfWord -1)) != 's')
            wordToCapitalize = new StringBuffer(wordToCapitalize).insert(lengthOfWord, "s").toString();

        return wordToCapitalize;
    }
}