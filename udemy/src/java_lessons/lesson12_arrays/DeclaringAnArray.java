package java_lessons.lesson12_arrays;

// An array is a data structure much like arraylist.
// The difference is that an array size must be declared
// when you declare the array and its size can never change.

// An ArrayList can grow constantly and never run out of room.
// Once you reach the number of elements in an array the array
// is full and you can't add new elements to it.

// But arrays are very fast and easier to use and don't require
// importing another class.  They are primimitive or native
// to the language.

public class DeclaringAnArray
{
   public static void main(String[] args)
   {
      int[] numbers = new int[10];
      char[] letters = new char[20];
      int[] nums = {1,2,3,4,5,6,7,8,9,10};
      String[] names = {"Jane", "Joe", "Mary", "Bob"};
   }
}