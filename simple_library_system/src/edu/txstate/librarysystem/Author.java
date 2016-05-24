package edu.txstate.librarysystem;

public class Author {
	private String firstName;
	private String middleInitial;
	private String lastName;
	
	public Author(String name) {
		String[] fullname = name.toString().split("\\s");
		if (fullname.length == 3) {
			this.firstName = fullname[0];
			this.middleInitial = fullname[1];
			this.lastName = fullname[2];
		} else if (fullname.length == 2) {
			this.firstName = fullname[0];
			this.middleInitial = "";
			this.lastName = fullname[1];
		}
	}
	
	public String toString() {
		String data =  "First name = " + getFirstName() + ", Middle initial = " + getMiddleInitial() 
		+ ", Last name = " + getLastName();
		return data;
	}
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getMiddleInitial() { return middleInitial; }
	public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
}
