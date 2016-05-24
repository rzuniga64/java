package edu.txstate.cs.simpleLib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import edu.txstate.search.DocumentSearch;

/**
 * 
 * @author Antonio Villegas
 *
 */
public class LibSystem implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LibSystem firstInstance = null;
	private List<Document> collectionDocument;
	private List<User> collectionUser;
	private List<Document> collectionItemsOnLoan;
	ArrayList<Author> authors = null;
//	DocumentSearch documentSearch;
	
	public static LibSystem getInstance() {
        if (firstInstance == null) {
            firstInstance = new LibSystem(); 
        }
        return firstInstance;
	}
	
	public LibSystem()
	{
		collectionDocument = new ArrayList<Document>();
		collectionUser = new ArrayList<User>();
		collectionItemsOnLoan = new ArrayList<Document>();
	}
	// setter
//	public void setDocumentSearch(DocumentSearch ds)
//	{
//		documentSearch = ds;
//	}
//	
//	public void performDocumentSearch() {
//		documentSearch.search();
//	}
	
	public void addDocument(Document document)
	{
		collectionDocument.add(document);
	}
	
	public void addUser(User user)
	{
		collectionUser.add(user);
	}
	
	public int getSizeDocuments()
	{
		return collectionDocument.size();
	}
	
	public int getSizeUsers()
	{
		return collectionUser.size();
	}
	
	public int getSizeItemsOnLoan()
	{
		return collectionItemsOnLoan.size();
	}
	
	public void addItemsOnLoan(Document document)
	{
		collectionItemsOnLoan.add(document);
	}
	
	public void removeItemsOnLoan(Document document)
	{
		collectionItemsOnLoan.remove(document);
	}
		
	// get user by name
	public User getUser(String nameUser)
	{
		User user;
		int index = findUser(nameUser);
		if (index == -1) {
			user = new User();
			return user;
		} else {
			return collectionUser.get(index);
		}
	}
	
	private int findUser(String nameUser)
	{
		if(nameUser == null)
		{
//			System.out.println("There is no user with that name.\n");
			return -1;
		}
		for(int i = 0; i < collectionUser.size(); i++)
		{
			User u = collectionUser.get(i);
			if(u.getName().equalsIgnoreCase(nameUser))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public void removeUserFromCollection(User user)
	{
		collectionUser.remove(user);
	}
	
	// get document by title
	// get document by author
	// get document by publisher
	public Document getDocument(String title)
	{
		int index = findDocument(title);
		return collectionDocument.get(index);
	}
	
	public int findDocument(String title)
	{
//		Author anAuthor;
		String anAuthor;
		if(title == null) return -1;
		
		authors = new ArrayList<Author>();
			
		
		for(int i = 0; i < collectionDocument.size(); i++)
		{
			Document d = collectionDocument.get(i);
			
			
			if(d.getTitle().equalsIgnoreCase(title))
			{
				return i;
			}
			else if(d.getPublisher().equalsIgnoreCase(title))
			{
				return i;
			}
			
			authors = d.getAuthor();
//			anAuthor = new Author(title);
			for(Author a : authors)
			{
				anAuthor = a.toString();
				
				if(anAuthor.equalsIgnoreCase(title))
				{
//					System.out.println("We found it. The index number is: " + i);
					return i;
					
				}
			}
			
//			else if(d.getAuthor().equalsIgnoreCase(title))
//			{
//				return i;
//			}
			
		}
		
		return -1;
		
	}
	
	// print user
	public void printUser(User u)
	{
		String uType;
		String message = null;
		if(u instanceof Student)
		{
			Student student = (Student)u;
			uType = "Student---> ";
			message = uType + "\t\tName: " + u.getName() + "\t\tID: " + u.getId() + "\t\tItems Checked Out: " 
			          + u.getItemsBorrowed() + "\t\tMaximum Items per Student: " + student.getMaximumItems(); 
		}
		else if(u instanceof Faculty)
		{
			Faculty faculty = (Faculty)u;
			uType = "Faculty---> ";
			message = uType + "\t\tName: " + u.getName() + "\t\tID: " + u.getId() + "\t\tItems Checked Out: " 
					  + u.getItemsBorrowed() + "\t\tMaximum Items per Faculty: " + faculty.getMaximumItems(); 
		}
		else if(u instanceof Staff)
		{
			Staff staff = (Staff)u;
			uType = "Staff ---> ";
			message = uType + "\t\tName: " + u.getName() + "\t\tID: " + u.getId() + "\t\tItems Checked Out: " 
					  + u.getItemsBorrowed() + "\t\tMaximum Items per Faculty: " + staff.getMaximumItems(); 
		}
		System.out.println(message);
	}
	
	public void printItemsOnLoan()
	{
		for(Document i : collectionItemsOnLoan)
		{
			System.out.println(i.toString());
		}
	}
	
	public void printListUsers()
	{
		for(User u : collectionUser)
		{
			printUser(u);
		}
	}
	
	// print document
	public void printDocument(Document d)
	{
		String dType;
		String message = null;
		if(d instanceof Book)
		{
			Book book = (Book)d;
			dType = "Book---> ";
			message = dType + "\t\tTitle: " + d.getTitle() + "\t\tPublisher: " 
			          + d.getPublisher() + "\t\tDate: " + d.getDate()
			          + "\t\tAuthor(s): " + d.getAuthor() 
			          + "\t\tISBN: " + book.getIsbn() + "\t\tCopies: " 
			          + book.getCopies();
		}
		else if(d instanceof Journal)
		{
			Journal journal = (Journal)d;
			dType = "Journal---> ";
			message = dType + "\t\tTitle: " + d.getTitle() + "\t\tPublisher: " 
			          + d.getPublisher() + "\t\tDate: " + d.getDate()
			          + "\t\tAuthor(s): " + d.getAuthor() 
			          + "\t\tVolume: " + journal.getVolume() + "\t\tIssue: " 
			          + journal.getIssue();
		}
		System.out.println(message);
	}
	
	// check out
	public boolean checkOut(Document d, User u)
	{
		if(d.getUser() == null)
		{
			d.setUser(u);
			return true;
		}
		else
		{
			return false;
		}
	}
	// check in
	public boolean checkIn(Document d, User u)
	{
		if(d.getUser() != null)
		{
			d.setUser(null);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	@Override
	public String toString()
	{
		String library = "";
//		String totalUsers = "";
		Iterator<Document> i = collectionDocument.iterator();
		Iterator<User> j = collectionUser.iterator();
		
		while(i.hasNext())
		{
			Document d = (Document) i.next();
			library =  library + d.toString();
		}
		
		while(j.hasNext())
		{
			User u = (User) j.next();
			library = library + u.toString();
		}
		
		return library;
	}
	
}
