package generic_programming;

public class ListDriver {
    public static void main (String[] args) {
        List<String> groceryList = new List<String>(10);
        groceryList.add("milk");
        groceryList.add("eggs");
        System.out.println("Grocery list: " + groceryList.toString());

        List<Integer> numbers = new List<Integer>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Numbers: " + numbers.toString());
    }
}
