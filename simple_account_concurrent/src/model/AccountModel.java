package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The type Account simpleAccount.view.model.
 */
public class AccountModel extends AbstractModel implements Serializable {
    private static final String accountsSer = "src\\simpleAccount\\model\\accounts.ser";
    private static final String accountstFile = "src\\simpleAccount\\model\\accounts.txt";

    private static final long serialVersionUID = 1L;
    /**
     * The Accounts.
     */
    public static ArrayList<AccountModel> accounts;

    private String name;
    private String id;
    private double amount;
    private double balance;
    private String state;
    private static double total = 0.0;

    /**
     * Instantiates a new Account simpleAccount.view.model.
     */
// Constructors
    public  AccountModel() {}

    private AccountModel(String name, String id, double amount) {
        this.name = name;
        this.id = id;
        this.amount = 0;
        this.balance = amount;
        this.state = "unmodified";
    }

    /**
     * Gets name.
     *
     * @return the name
     */
// Getters and Setters
    public String getName() { return this.name; }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getID() { return this.id; }
    private double getAmount() { return this.amount; }
    private void setAmount(double amount) {this.amount = amount; }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() { return this.balance; }
    private void setBalance(double balance) { this.balance = balance; }
    private String getState() { return state; }
    private void setState(String state) { this.state = state; }

    public String toString() {
        return "Name = " + getName() + ",\tID = " + getID() + ",\tAmount = " + getAmount()
                + ",\tBalance = " + getBalance() + ",\tState = " + getState();
    }

    /**
     * Reads from an input file and stores it in a serialized file
     *
     */

    //public static void readAccountInputFile(String filename) {
    public static void readAccountInputFile() {
        String currency;
        ArrayList<AccountModel> accountList = new ArrayList<AccountModel>();
        try {
            Scanner inFile = new Scanner(new FileReader(accountstFile));
            FileOutputStream fos = new FileOutputStream(accountsSer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            while (inFile.hasNextLine()) {
                if (inFile.hasNext("name")) {
                    inFile.nextLine();
                } else {
                    String[] content = inFile.nextLine().split("\\@");
                    currency = content[2].replaceAll("\\t", "").substring(0,1);
                    content[0] = content[0].replaceAll("\\t", "");
                    content[1] = content[1].replaceAll("\\t", "");
                    content[2] = content[2].replaceAll("\\t", "").replace(currency,"");
                    AccountModel am = new AccountModel( content[0], content[1], Double.parseDouble(content[2]));
                    accountList.add(am);
                }
            }
            // Sort the accounts in ascending order by account id
            Collections.sort(accountList, AccountModel.AcctID );
            // write the accounts to serialized file
            oos.writeObject(accountList);
            inFile.close();
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Can't access file");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Null pointer exception.");
            e.printStackTrace();
        }
    }

    private static Comparator<AccountModel> AcctID = new Comparator<AccountModel>() {
        public int compare(AccountModel am1, AccountModel am2) {
            long id1 = Long.parseLong(am1.getID());
            long id2 = Long.parseLong(am2.getID());
            return Long.compare(id1, id2);
        }
    };

    /**
     * Reads account information from a serialized file and returns it in an ArrayList.
     *
     * @return the array list
     */
    public static  ArrayList<AccountModel> readAccountInfo() {
        ArrayList<AccountModel> accountList = null;
        try {
            FileInputStream fis = new FileInputStream(accountsSer);
            ObjectInputStream ois = new ObjectInputStream(fis);
            accountList = (ArrayList<AccountModel>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Can't access file");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    /**
     * Writes the list of all sccount to a serialized file
     *  accounts stored in a serialized file
     *
     * @param accountList the account list
     */
    public void writeAccounts(ArrayList<AccountModel> accountList) {
        try {
            FileOutputStream fos = new FileOutputStream(accountsSer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't access file");
            e.printStackTrace();
        }
    }

    /**
     * Print account list.
     */
    public static void printAccountList() {
        ArrayList<AccountModel> accountList = readAccountInfo();
        for (AccountModel account: accountList)
            System.out.println(account.toString());
        System.out.println("\n");
    }

    /**
     * Add the deposit amount to the current balance
     *
     * @param accountID the account id
     * @param amount    the amount
     */
    public void deposit(String accountID, double amount)  {

        for (AccountModel acct: accounts) {
            if (acct.getBalance() > 0 && acct.getID().equals(accountID ) && amount >= 1) {
                acct.setState("modified");
                acct.setAmount(amount);
                total = acct.getBalance() + amount;
                acct.setBalance(total);
                ModelEvent me = new ModelEvent(acct, 1, "", total);
                acct.notifyChanged(me);
                break;
            }
        }
    }

    /**
     * Subtract the withdrawal to the current balance
     *
     * @param accountID the account id
     * @param amount    the amount
     */
    public void withdrawal(String accountID, double amount) {
        for (AccountModel acct: accounts) {
            if ( (acct.getBalance() - amount >= 0) && (acct.getID().equals(accountID)) && (amount >= 1)) {
                    acct.setState("modified");
                    acct.setAmount(amount);
                    total = acct.getBalance() - amount;
                    acct.setBalance(total);
                    ModelEvent me = new ModelEvent(acct, 1, "", total);
                    acct.notifyChanged(me);
                    break;
            } else if (acct.getBalance() - amount < 0) {
                throw new IllegalArgumentException("Insufficient funds: amount to withdraw is greater than available fund: " + Double.toString(acct.getBalance()));
            }
        }
    }
}
