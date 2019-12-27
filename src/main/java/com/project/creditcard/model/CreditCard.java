package com.project.creditcard.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="creditcards")
public class CreditCard {
	
	@Id
	private String id;
	private String cardNumber;
	private BigDecimal balance;
	private BigDecimal maxLimit;
	private String expirationDate;
	private BigDecimal minAmount;
	private BigDecimal totalAmount;
	private BigDecimal amount;
	private Client client;
	private String currency;
	
	public CreditCard() {
		
	}
	
	public CreditCard(String id, String cardNumber, BigDecimal balance, BigDecimal maxLimit, String expirationDate,
			BigDecimal minAmount, BigDecimal totalAmount, BigDecimal amount, Client client, String currency) {
		this.id = id;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.maxLimit = maxLimit;
		this.expirationDate = expirationDate;
		this.minAmount = minAmount;
		this.totalAmount = totalAmount;
		this.amount = amount;
		this.client = client;
		this.currency = currency;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public BigDecimal getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
