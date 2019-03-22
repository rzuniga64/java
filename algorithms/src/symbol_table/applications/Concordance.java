/******************************************************************************
 *  Compilation:  javac Concordance.java
 *  Execution:    java Concordance < input.txt
 *  Dependencies: ST.java SET.java In.java StdIn.java
 *
 *  % java Concordance tale.txt
 *  cities
 *  tongues of the two *cities* that were blended in 
 *
 *  majesty
 *  their turnkeys and the *majesty* of the law fired 
 *  me treason against the *majesty* of the people in 
 *  of his most gracious *majesty* king george the third 
 *
 *  princeton
 *
 *  Build a concordance for a text corpus.
 *
 ******************************************************************************/
package symbol_table.applications;

import edu.princeton.cs.algs4.*;

public class Concordance {

    public static void main(String[] args) {
        int CONTEXT = 5;

        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        ST<String, SET<Integer>> st = new ST<String, SET<Integer>>();

        // build up concordance
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!st.contains(s)) {
                st.put(s, new SET<Integer>());
            }
            SET<Integer> set = st.get(s);
            set.add(i);
        }
        StdOut.println("Finished building concordance");

        // process queries
        In in2 = new In();
//        while (!StdIn.isEmpty()) {
        while (!in2.isEmpty()) {

            String query = in2.readString();
            SET<Integer> set = st.get(query);
            if (set == null) set = new SET<Integer>();
            for (int k : set) {
                for (int i = Math.max(0, k - CONTEXT + 1); i < k; i++)
                    StdOut.print(words[i] + " ");
                StdOut.print("*" + words[k] + "* ");
                for (int i = k + 1; i < Math.min(k + CONTEXT, words.length); i++)
                    StdOut.print(words[i] + " ");
                StdOut.println();
            }
            StdOut.println();
        }
    }
}
