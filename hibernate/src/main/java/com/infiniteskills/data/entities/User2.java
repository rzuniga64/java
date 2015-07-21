package com.infiniteskills.data.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 	The class and fields are annotated with these annotations that provide with the
 * 	information needed to instruct SQL to persist this object within a database.
 * 	The annotations on this class such as the @Entity, @Table and @Column can also be
 * 	used to perform other types of operations such as SELECT, UPDATE or DELETE.
 *
 * 	Another best practice when it comes to entities is to follow Javabean naming
 * 	conventions. So when we create those POJO we will have these private fields
 * 	and we will create the accessors for these fields. The accessors reflect the
 * 	field name prefixed with set or get and we camelcase the fieldname.
 */

@Entity
@Table(name = "finances_user")
public class User2 {
    /** @Id must always be in placed within an entity. Denotes a
     * field that corresponds to the primary key in the
     * table that this object is associated with. */
    /** @GeneratedValue is used to specify how we obtain the value
     * 	value of the primary key for a particular field. Some
     * 	databases use auto numbers, some use sequences. There is
     * 	also the option for Hibernate to provide this value and
     * 	we can use the @GneratedValue to specify that. */

    /**	 @Column allows us to specify the corresponding column for this field. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="BIRTH_DATE")
    private Date birthDate;

    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name="LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name="LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="CREATED_BY")
    private String createdBy;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
