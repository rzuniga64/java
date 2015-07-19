/* this program is based on a similar program in
   Java Programming: Advanced Topics, Wigglesworth and McMillan

   Concurrent programming is quite complex. One problem is we
   create object oriented programs where we use inheritance
   there is a problem using the thread class as a superclass.
   Notice ComputeLog and UserInteraction extend the Thread class.
   The problem is if I have a Vehicle class, for example, that in
   turn is derives another class called Car I can't also extend
   that class to include thread.  So what we have to do instead
   is write our classes as implementations of the interface
   called Runnable. The Runnable interface allows us to create
  a derived class that is derived from a base or superclass
   that also can be written in its own thread or written as a
   multi-threaded program.
*/
package java_lessons.lesson24_multithread_programming;

import java.io.*;

public class TwoThreads {
   public static void main(String[] args) throws InterruptedException {
      Thread firstThread = new UserInteraction();
      firstThread.start();
      Thread secondThread = new ComputeLog();
      secondThread.start();
      // the join method waits for the thread process to terminate
      // once that thread process is terminated we go to the second
      // thread and call end to it.
      firstThread.join();
      // cast thread back to ComputeLog because the end method is part
      // of the ComputeLog class not the thread class.
      ((ComputeLog) secondThread).end();
   }
}

class UserInteraction extends Thread {
   public void run() {
      try {
         BufferedReader userIn = new BufferedReader(
            new InputStreamReader(System.in));
         System.out.print("Hello, how are you? ");
         String in = userIn.readLine();
         System.out.print("What are you doing today? ");
         in = userIn.readLine();
         System.out.println(in + " sounds like fun.");
      }
      catch (IOException e) {
         System.out.println("Caught I/O exception.");
      }
   }
}
         
class ComputeLog extends Thread {
   private static boolean stop = false;
   public void run() {
      try {
         int i = 1;
         double d = 0;
         while (!stop) {
            d = Math.log(i++);
            sleep(1);
         }
         System.out.println("The log of " + i + " is " + d);
      } 
      catch (InterruptedException e) {
         System.out.println("Thread execution was interrupted.");
      }
   }

   public void end() {
      stop = true;
   }
} 

  