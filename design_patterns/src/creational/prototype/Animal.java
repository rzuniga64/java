package creational.prototype;

/**
 *  By making this class cloneable you are telling Java that it is ok to copy
 *  instances of this class. These instance copies are going to be stored in
 *  different locations in memory. it is a copy not a reference.
 */
interface Animal extends Cloneable {

    /** makeCopy method. */
    Animal makeCopy();
}
