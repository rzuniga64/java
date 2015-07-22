package basic_bean_configuration;

/** Create a spring bean which is just an ordinary Java object configured by spring.*/

/** We want person to have an address property. We need a way to give an Address
 *  object to a Person object. We can make the address a constructor argument or
 *  create a set method for address. Outside of Spring you could create an Address
 *  objecct and pass it to a Person object in the application.
 *
 *  Spring allows us to inject an Address object into a Person object. You can inject
 *  objects into each other. Inject dependencies in other words because Address is a
 *  dependency of Person.  So create a set method for address and then create a bean
 *  property for Person named address.
 */

public class Person {
    private int id;
    private String name;
    private int taxId;
    private Address address;

    public Person(){}
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id +
                ", name='" + name + '\'' +
                ", taxId=" + taxId +
                ", address=" + address +
                '}';
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    // we inject an Address into the Person
    public void setAddress(Address address) {
        this.address = address;
    }

    public void speak() {
        System.out.println("Hello! I'm a person");
    }
}