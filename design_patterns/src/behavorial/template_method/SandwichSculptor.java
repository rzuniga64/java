package behavorial.template_method;

/**
 * The type Sandwich sculptor.
 */
public class SandwichSculptor {

    /**
     *  Main.
     *  @param args the args
     */
    public static void main(String[] args){

        ItalianHoagie cust12Hoagie = new ItalianHoagie();
        cust12Hoagie.makeSandwich();

        System.out.println();

        VeggieHoagie cust13Hoagie = new VeggieHoagie();
        cust13Hoagie.makeSandwich();
    }
}