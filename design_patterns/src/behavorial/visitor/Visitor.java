package behavorial.visitor;

/**
 *  The Visitor interface.
 *  The Visitor pattern is used when you have to perform the same action on many objects of different types.
 *  Created to automatically use the right code based on the Object sent.
 */
interface Visitor {

    /**
     * Visit method for liquor.
     * @param liquorItem the liquor item
     * @return the double
     */
    double visit(Liquor liquorItem);

    /**
     * Visit method for tobacco.
     * @param tobaccoItem the tobacco item
     * @return the double
     */
    double visit(Tobacco tobaccoItem);

    /**
     * Visit method for necessity item, such as milk.
     * @param necessityItem the necessity item
     * @return the double
     */
    double visit(Necessity necessityItem);
}
