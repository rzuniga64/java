package com.infiniteskills.data.entities.composite_value_types;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="BANK")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BANK_ID")
	private Long bankId;

	@Column(name="NAME")
	private String name;
	
	@Embedded
	// custom class with fields that correspond with our database columns in the database.
	private Address address = new Address();

	@Column(name="IS_INTERNATIONAL")
	private boolean international;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="CREATED_BY")
	private String createdBy;

    /** add a list of Bank contacts
     *  @ElementCollection says we are trying to map a collection of instances that are a basic or embeddable class.
     *  @CollectionTable this is how we are going to provide Hibernate the mapping metadata for the table that was
     *  created to hold the bank contact information.
     *  @Column specifies the actual column that will hold the name of our contacts.  This is the column within
     *  the BANK_CONTACT table.  We needed to add a POSITION_TYPE column to the BANK_CONTACT table that holds the
     *  key for the map.
     */
    @ElementCollection
    @CollectionTable(name="BANK_CONTACT", joinColumns = @JoinColumn(name="BANK_ID"))
    // name of the column that holds our key for the map
    @MapKeyColumn(name="POSITION_TYPE")
    // name will be the name of the column that holds the value for the map
    @Column(name="NAME")
    //private Collection<String> contacts = new ArrayList<String>();
    private Map<String, String> contacts = new HashMap<String, String>();

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return address.getAddressLine1();
	}

	public void setAddressLine1(String addressLine1) {
		this.address.setAddressLine1(addressLine1);
	}

	public String getAddressLine2() {
		return address.getAddressLine2();
	}

	public void setAddressLine2(String addressLine2) {
		this.address.setAddressLine2(addressLine2);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		this.address.setCity(city);
	}

	public String getState() {
		return address.getState();
	}

	public void setState(String state) {
		this.address.setState(state);
	}

	public String getZipCode() {
		return address.getZipCode();
	}

	public void setZipCode(String zipCode) {
		this.address.setZipCode(zipCode);
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() { return createdBy; }

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

    // public Collection<String> getContacts() { return contacts; }
    // public void setContacts(Collection<String> contacts) { this.contacts = contacts; }

    public Map<String,String> getContacts() { return contacts; }

    public void setContacts(Map<String, String> contacts) { this.contacts = contacts; }
}
