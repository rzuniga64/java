package visitor;

/**
 *  The interface Visitor.
 *  The visitor pattern is used when you have to perform the same action on many objects of different types.
 *  Created to automatically use the right code based on the Object sent.
 */
interface Visitor {

    /**
     * Visit double.
     *
     * @param liquorItem the liquor item
     * @return the double
     */
    double visit(Liquor liquorItem);

    /**
     * Visit double.
     *
     * @param tobaccoItem the tobacco item
     * @return the double
     */
    double visit(Tobacco tobaccoItem);

    /**
     * Visit double.
     *
     * @param necessityItem the necessity item
     * @return the double
     */
    double visit(Necessity necessityItem);
}
