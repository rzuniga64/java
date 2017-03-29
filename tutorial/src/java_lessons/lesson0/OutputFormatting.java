package java_lessons.lesson0;

import java.util.ArrayList;

/**
 *  To get you started, a portion of the solution is provided for you in the
 *  editor; you must format and print the input to complete the solution.
 *
 *  Input Format
 *
 *  Every line of input will contain a String followed by an integer.
 *  Each String will have a maximum of  alphabetic characters, and each integer
 *  will be in the inclusive range from to .
 *
 *  Output Format
 *
 *  In each line of output there should be two columns:
 *  The first column contains the String and is left justified using exactly
 *  characters.
 *  The second column contains the integer, expressed in exactly  digits; if the
 *  original input has less than three digits, you must pad your output's leading
 *  digits with zeroes.
 *
 *  Sample Input
 *
 *  java 100
 *  cpp 65
 *  python 50
 *  Sample Output
 *
 *  ================================
 *  java           100
 *  cpp            065
 *  python         050
 *  ================================
 *  Explanation
 *
 *  Each String is left-justified with trailing whitespace through the first
 *  characters. The leading digit of the integer is the  character, and each
 *  integer that was less than  digits now has leading zeroes.
 */
public class OutputFormatting
{
    public static void main(String[] args) {

        ArrayList<String> li = new ArrayList<>();
        li.add("java");
        li.add("cpp");
        li.add("python");

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(100);
        l2.add(65);
        l2.add(50);

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s %03d\n", li.get(i), l2.get(i));
        }
    }
}
