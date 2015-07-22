package basic_bean_configuration;

public class Address {
    private String street;
    private String postcode;

    public Address() {}
    public Address(String street, String postcode) {
        this.street = street;
        this.postcode = postcode;
    }

    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", postcode='" + postcode + '\'' + '}';
    }
}
