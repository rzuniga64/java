package com.infiniteskills.data.entities._06_entity_associations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BUDGET")
public class BudgetJoinTable {

	@Id
	@GeneratedValue
	@Column(name = "BUDGET_ID")
	private Long budgetId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GOAL_AMOUNT")
	private BigDecimal goalAmount;

	@Column(name = "PERIOD")
	private String period;

	@OneToMany(cascade=CascadeType.ALL)
	/** @JoinTable is a JPA annotation
     *  Start with join column of the owning entity(Budget). You can choose which side you want to place the
     *  @JoinTable annotation. Then specify the inverse join column of TransactionHibernateAPI entity. */
	@JoinTable(name="BUDGET_TRANSACTION", joinColumns=@JoinColumn(name="BUDGET_ID"), 
		inverseJoinColumns=@JoinColumn(name="TRANSACTION_ID"))
	private List<TransactionBiDirectionalOneToMany> transactions = new ArrayList<TransactionBiDirectionalOneToMany>();
	
	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<TransactionBiDirectionalOneToMany> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionBiDirectionalOneToMany> transactions) {
		this.transactions = transactions;
	}
}
