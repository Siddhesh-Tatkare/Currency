package com.model;

import javax.persistence.*;

@Entity
public class Currency {
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private double amount;
	private String fromCurrency;
	private String toCurrency;
	
	public double getAmount() {
		return amount;
	}
	public double setAmount(double amount) {
		return this.amount = amount;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public String setFromCurrency(String fromCurrency) {
		return this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public String setToCurrency(String toCurrency) {
		return this.toCurrency = toCurrency;
	}
}
