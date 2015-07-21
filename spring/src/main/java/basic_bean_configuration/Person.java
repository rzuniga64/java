package basic_bean_configuration;

/** Create a spring bean which is just an ordinary Java object configured by spring.*/

public class Person {
    private int id;
    private String name;
    private int taxId;

    public Person(){}
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id + ", name='" + name + '\'' + ", taxId=" + taxId + '}';
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public void speak() {
        System.out.println("Hello! I'm a person");
    }
}