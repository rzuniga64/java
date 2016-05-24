package edu.txstate.librarysystem;

import java.io.IOException;
import java.util.Scanner;

public class Main
{	
	public static void main(String[] args) throws IOException {
		
	int menuItem = -1;
	while(menuItem != 0) {
         menuItem = menu();
         switch(menuItem) {
            case 1:
               LibraryServices lb1 = new LibraryServices();
               lb1.search();
               break;
            case 2:
                LibraryServices lb2 = new LibraryServices();
                lb2.loanDocument();
               break;
            case 3:
                LibraryServices lb3 = new LibraryServices();
                lb3.returnDocument();
               break;
            case 4:
                LibraryServices lb4 = new LibraryServices();
                lb4.displayLoanItems();
	            break;  
            case 5:
            	LibraryServices lb5 = new LibraryServices();
            	lb5.addDocument();
	            break;
            case 6:
            	LibraryServices lb6 = new LibraryServices();
            	lb6.registerUser();
	            break;
            case 0:
               break;
            default:
               System.out.println("Don't recognize input.");
         }
	}
}
	
   static int menu(){ 
	      int choice;
	      Scanner input = new Scanner(System.in);
	      System.out.println("\nMain Menu\n");
	      System.out.println("0. Exit the program");
	      System.out.println("1. Search for document");
	      System.out.println("2. Borrow a book");
	      System.out.println("3. Return a book");
	      System.out.println("4. List of currently loaned documents");
	      System.out.println("5. Add a new document");
	      System.out.println("6. Register a new user");	      
	      System.out.println();
	      System.out.print("Enter a choice: ");
	      choice = input.nextInt();
	      return choice;
	   }
}

