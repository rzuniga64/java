package com.infiniteskills.data.entities._09_advanced_mappings_and_configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.ids.CurrencyId;

@Entity
// Add @IdClass annotation for class that specifies the primary keys for the Currency class.
// This will map a concatenated natural primary key for the Currency table.
@IdClass(CurrencyId.class)
public class Currency {

	@Id
	@Column(name="NAME")
	private String name;

	@Id
	@Column(name="COUNTRY_NAME")
	private String countryName;

	@Column(name="SYMBOL")
	private String symbol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
