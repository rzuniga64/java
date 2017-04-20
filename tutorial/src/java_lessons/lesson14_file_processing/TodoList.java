package java_lessons.lesson14_file_processing;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * TodoList class.
 *  Scanner used to get input from a file.
 *  FileReader is to open up a file for reading.
 *  PrintWriter is the class that allows us to write data to a file.
 *  FileWriter opens a file for output.
 *  Must add throws IOException to the main function.
 */
public final class TodoList {

    /**
     * File to store our todo list.
     */
    static final String fileName =
            "tutorial\\src\\java\\lesson14_file_processing\\todo.txt";

    /**
     * Constructor.
     */
    private TodoList() {
    }

    /**
     * Unit tests.
     *
     * @param args the arguments
     * @throws IOException IOException
     */
    public static void main(final String[] args) throws IOException {

        int menuItem = -1;
        while (menuItem != 0) {
            menuItem = menu();
            switch (menuItem) {
                case 1:
                    showList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Don't recognize input.");
            }
        }
    }

    /**
     * Display a menu to the user.
     *
     * @return the choice the user selected from the menu
     */
    private static int menu() {

        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\nMain Menu\n");
        System.out.println("0. Exit the program");
        System.out.println("1. Display to-do list");
        System.out.println("2. Add item to to-do list");
        System.out.println("3. Remove item from to-do list");
        System.out.println();
        System.out.print("Enter a choice: ");
        choice = input.nextInt();
        return choice;
    }

    /**
     * Show the todo list.
     */
    private static void showList() {

        System.out.println("\nTo-do List\n");
        try {
            Scanner inFile = new Scanner(new FileReader(fileName));
            String line;
            int number = 1;
            while (inFile.hasNextLine()) {
                line = inFile.nextLine();
                System.out.print(number + " ");
                System.out.println(line);
                ++number;
            }
            System.out.println();
            inFile.close();
        } catch (IOException ioe) {
            System.out.println("Can't access file.");
        }
    }

    /**
     * Add a todo to the todo list.
     */
    private static void addItem() {

        System.out.println("\nAdd Item\n");
        try {
            Scanner input = new Scanner(System.in);
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName, true));
            System.out.print("Enter an item: ");
            String item = input.nextLine();
            outFile.println(item);
            outFile.close();
        } catch (IOException ioe) {
            System.out.println("Can't access file.");
        }
    }

    /**
     * Remove a todo from the todo list.
     */
    private static void removeItem() {

        int choice;
        showList();
        Scanner input = new Scanner(System.in);
        System.out.print("Which item do you want to remove? ");
        choice = input.nextInt();
        ArrayList<String> items = new ArrayList<>();
        int number = 1;
        try {
            Scanner inFile = new Scanner(new FileReader(fileName));
            String item;
            while (inFile.hasNextLine()) {
                item = inFile.nextLine();
                if (number != choice) {
                    items.add(item);
                }
                ++number;
            }
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
            for (String theitem : items) {
                outFile.println(theitem);
            }
            outFile.close();
        } catch (IOException ioe) {
            System.out.println("Can't access file.");
        }
    }
}

