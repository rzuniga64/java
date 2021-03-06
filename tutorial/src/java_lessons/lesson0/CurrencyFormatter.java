package java_lessons.lesson0;

import java.util.Locale;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *  Given a double-precision number, , denoting an amount of money, use the NumberFormat class' getCurrencyInstance
 *  method to convert  into the US, Indian, Chinese, and French currency formats. Then print the formatted values:
 *  according to the appropriate Locale's currency. Note: India does not have a built-in Locale, so you must construct
 *  one where the language is en (i.e., English).
 *
 *  US: formattedPayment
 *  India: formattedPayment
 *  China: formattedPayment
 *  France: formattedPayment
 *
 *  Input Format
 *  A single double-precision number denoting .
 *  Constraints: 0 <= payment <= pow(10,9)
 *
 *  Output Format
 *  On the first line, print US: u where  is payment formatted for US currency.
 *  On the second line, print India: i where i is payment formatted for Indian currency.
 *  On the third line, print China: c where c is payment formatted for Chinese currency.
 *  On the fourth line, print France: f, where f is payment formatted for French currency.
 *
 *  Sample Input
 *  12324.134
 *
 *  Sample Output
 *  US: $12,324.13
 *  India: Rs.12,324.13
 *  China: ￥12,324.13
 *  France: 12 324,13 €
 */
public class CurrencyFormatter {

    private CurrencyFormatter() { }

    /**
     *  Unit tests for CurrencyFormatter.
     *  @param args args
     */
    public static void main(final String[] args) {

        System.out.println("Enter a US currency: ");
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
