package data_structure.linkedlist;

public class LinkList{

    private class Link {

        private String bookName;
        private int millionsSold;

        // Reference to next link made in the data_structure.linkedlist.LinkList.
        // Holds the reference to the Link that was created before it
        // Set to null until it is connected to other links

        public Link next;

        public Link(String bookName, int millionsSold){
            this.bookName = bookName;
            this.millionsSold = millionsSold;
        }

        public void display(){ System.out.println(bookName + ": " + millionsSold + ",000,000 Sold"); }
        public String toString(){ return bookName; }

    }

    // Reference to first Link in list
    // The last Link added to the LinkedList
    private  Link firstLink;

    private LinkList(){ firstLink = null; }

    // Returns true if data_structure.linkedlist.LinkList is empty
    private boolean isEmpty(){ return(firstLink == null); }

    //  To add a New Link
    //  - New link is created
    //  - It's Next is assigned the reference to the previous Link created
    //  - The data_structure.linkedlist.LinkList's firstLink is assigned a reference to the newest Link added.

    private void insertFirstLink(String bookName, int millionsSold){

        Link newLink = new Link(bookName, millionsSold);
        // Connects the firstLink field to the new Link
        newLink.next = firstLink;
        firstLink = newLink;
    }

    private Link removeFirst(){

        Link linkReference = firstLink;
        if(!isEmpty())
            firstLink = firstLink.next; // Removes the Link from the List
        else
            System.out.println("Empty LinkedList");

        return linkReference;
    }

    private void display(){

        Link theLink = firstLink;
        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null

        while(theLink != null){
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName){
        Link theLink = firstLink;

        if(!isEmpty()){
            while(!theLink.bookName.equals(bookName)){
                // Checks if at the end of the LinkedList
                if(theLink.next == null)
                    // Got to the end of the Links in LinkedList without finding a match
                    return null;
                else
                    // Found a matching Link in the LinkedList
                    theLink = theLink.next;
            }
        } else
            System.out.println("Empty LinkedList");

        return theLink;
    }

    private Link removeLink(String bookName){

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        // Keep searching as long as a match isn't made
        while(!currentLink.bookName.equals(bookName)){

            // Check if at the last Link in the LinkedList
            if(currentLink.next == null){
                // bookName not found so leave the method
                return null;
            } else {
                // We checked here so let's look in the next Link on the list
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if(currentLink == firstLink){
            // If you are here that means there was a match
            // in the reference stored in firstLink in the
            // LinkedList so just assign next to firstLink

            firstLink = firstLink.next;
        } else {
            // If you are here there was a match in a Link other
            // than the firstLink. Assign the value of next for
            // the Link you want to delete to the Link that's
            // next previously pointed to the reference to remove

            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstLink);

            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args) {

        LinkList theLinkedList = new LinkList();

        // Insert Link and add a reference to the book Link added just prior to the field next
        theLinkedList.insertFirstLink("Don Quixote", 500);
        theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
        theLinkedList.insertFirstLink("The Lord of the Rings", 150);
        theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);

        theLinkedList.display();
        System.out.println("Value of first in LinkedList " + theLinkedList.firstLink + "\n");

        // Removes the last Link entered
        theLinkedList.removeFirst();
        theLinkedList.display();
        System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");
        theLinkedList.removeLink("A Tale of Two Cities");
        System.out.println("\nA Tale of Two Cities Removed\n");
        theLinkedList.display();
    }
}