package com.infiniteskills.data.entities._07_hibernate_api;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CREDENTIAL")
public class CredentialHibernateAPI {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CREDENTIAL_ID")
	public Long credentialId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public UserHibernateAPI user;
	
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	
	public UserHibernateAPI getUser() {
		return user;
	}

	public void setUser(UserHibernateAPI userHibernateAPI) {
		this.user = userHibernateAPI;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
