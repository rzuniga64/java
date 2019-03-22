/******************************************************************************
 *  Compilation:  javac FileIndex.java
 *  Execution:    java FileIndex file1.txt file2.txt file3.txt ...
 *  Dependencies: ST.java SET.java In.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/35applications/ex1.txt
 *                https://algs4.cs.princeton.edu/35applications/ex2.txt
 *                https://algs4.cs.princeton.edu/35applications/ex3.txt
 *                https://algs4.cs.princeton.edu/35applications/ex4.txt
 *
 *  % java FileIndex ex*.txt
 *  age
 *   ex3.txt
 *   ex4.txt 
 * best
 *   ex1.txt 
 * was
 *   ex1.txt
 *   ex2.txt
 *   ex3.txt
 *   ex4.txt 
 *
 *  % java FileIndex *.txt
 *
 *  % java FileIndex *.java
 *
 ******************************************************************************/

package symbol_table.applications;

import edu.princeton.cs.algs4.*;

import java.io.File;

/**
 *  The FileIndex class provides a client for indexing a set of files, specified as command-line arguments. It takes
 *  queries from standard input and prints each file that contains the given query.
 *
 *  For additional documentation, see href="https://algs4.cs.princeton.edu/35applications", Section 3.5 of
 *  Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne.
 *  
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FileIndex { 

    // Do not instantiate.
    private FileIndex() { }

    public static void main(String[] args) {

        // key = word, value = set of files containing that word
        ST<String, SET<File>> st = new ST<String, SET<File>>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new SET<File>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }

        // read queries from standard input, one per line
        In in2 = new In();
//        while (!StdIn.isEmpty()) {
        while (!in2.isEmpty()) {
//            String query = StdIn.readString();
            String query = in2.readString();
            if (st.contains(query)) {
                SET<File> set = st.get(query);
                for (File file : set) {
                    StdOut.println("  " + file.getName());
                }
            }
        }
    }
}