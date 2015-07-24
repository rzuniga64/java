package com.infiniteskills.data.entities.entity_associations;

import javax.persistence.*;

@Entity
@Table(name="CREDENTIAL")
public class CredentialBiDirectionalOneToOne {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CREDENTIAL_ID")
	public Long credentialId;

    /** @oneToOne is a JPA annotation. Cascade means that when we persist the credential we also want to persist the
     * user that is stored within this field.  This will cause both entities to be persisted at the same time.*/
	@OneToOne(cascade=CascadeType.ALL)
    /** @JoinColumn is a JPA annotation. It specifies the column that should be used to join the tables. So it is
     * the foreign key column within CredentialUniDirectionalOneToOne. that was the USER_ID column. */
	@JoinColumn(name="USER_ID")
	/** user is our target entity. Credential is the source because it holds the foreign key in the Credential table.
		Unidirectional we can only access the user from the credential */
	public UserBidirectionalOneToOne user;
	
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	public UserBidirectionalOneToOne getUser() { return user; }

	public void setUser(UserBidirectionalOneToOne user) { this.user = user; }

	public Long getCredentialId() { return credentialId; }

	public void setCredentialId(Long credentialId) { this.credentialId = credentialId; }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }
}
