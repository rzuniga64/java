package java_lessons.lesson8_classes;

/**
 * Name class.
 */
public class Name {
    /** First aname variable. */
    private String first;
    /** Middle initial variable. */
    private String middle;
    /** Last name variable. */
    private String last;

    /**
     * Parametrzed constructor.
     * @param f first name
     * @param m middle name
     * @param l last name
     */
    public Name(final String f, final String m, final String l) {
        first = f;
        middle = m;
        last = l;
    }

    /**
     * Overloaded constructor.
     * @param f first name
     * @param l last name
     */
    private Name(final String f, final String l) {
        first = f;
        middle = "";
        last = l;
    }

    /**
     * Overloaded constructor.
     * @param l last name
     */
    private Name(final String l) {
        first = "";
        middle = "";
        last = l;
    }

    /** Default construcgtor. */
    private Name() {
        first = "";
        middle = "";
        last = "";
    }

    /**
     * Display the state of the object at any particular time.
     * @return the object as a string
     */
    public String toString() {
        return first + " " + middle + " " + last;
    }

    /**
     * Get the first name.
     * @return the first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Get the middle name.
     * @return the middle name
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * Get the last name.
     * @return the last name
     */
    public String getLast() {
        return last;
    }

    /**
     * Set the first name.
     * @param fname first name
     */
    public void setFirst(final String fname) {
        first = fname;
    }

    /**
     * Set the middle name.
     * @param mname middle name
     */
    public void setMiddle(final String mname) {
        middle = mname;
    }

    /**
     * Set the last name.
     * @param lname last name.
     */
    public void setLast(final String lname) {
        last = lname;
    }

    /**
     * Set the full name.
     * @param f first name
     * @param m middle name
     * @param l last name
     */
    public void setName(final String f, final String m, final String l) {
        first = f;
        middle = m;
        last = l;
    }

    /**
     * Get the initials of a person.
     * @return the initials
     */
    public String getInitials() {
        return first.substring(0, 1) + middle.substring(0, 1)
                                    + last.substring(0, 1);
    }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        Name myName = new Name("Raul", "Zuniga");
        Name yourName = new Name("Randy", "Burcham");
        Name dogName = new Name("Cinnamon");
        Name someName = new Name();

        System.out.println("myName: " + myName.toString());
        System.out.println("myName: " + yourName.toString());
        System.out.println("myName: " + dogName.toString());
        System.out.println("myName first name: " + myName.getFirst());
        yourName.setLast("Brown");
        System.out.println("yourName: " + yourName.toString());
        someName.setName("John", "Quincy", "Adams");
        System.out.println("someName: " + someName.toString());
    }
}


