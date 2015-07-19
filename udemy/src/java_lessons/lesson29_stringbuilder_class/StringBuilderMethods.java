package java_lessons.lesson29_stringbuilder_class;

public class StringBuilderMethods {
    public static void main(String[] args) {
        //StringBuilder sentence = new StringBuilder();
        StringBuilder sentence = new StringBuilder("Now the time");
        System.out.println(sentence.toString());

        sentence.insert(4, "is ");
        System.out.println(sentence.toString());
        System.out.println("the is found at pos: " + sentence.indexOf("the"));
        sentence.delete(4, 6);
        System.out.println(sentence.toString());
        sentence.deleteCharAt(3);
        System.out.println(sentence.toString());
        sentence.reverse();  // can  be used to check for palindromes
        System.out.println(sentence.toString());
    }
}
