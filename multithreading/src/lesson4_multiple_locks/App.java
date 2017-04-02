package lesson4_multiple_locks;

/**
 *  Codes with minor comments are from
 *  <a href="http://www.caveofprogramming.com/youtube/">
 *  <em>http://www.caveofprogramming.com/youtube/</em>
 *  </a>
 *  <br>
 *  also freely available at
 *  <a href="https://www.udemy.com/java-multithreading/?couponCode=FREE">
 *      <em>https://www.udemy.com/java-multithreading/?couponCode=FREE</em>
 *  </a>
 */

public class App {

    public static void main(String[] args) {
        System.out.println("Synchronized Objects: ");
        Worker worker = new Worker();
        worker.main();
    }
}
