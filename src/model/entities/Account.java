package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	public Account(Integer number, String holder, Double balance, Double withdrawLimit)  throws DomainException{
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void deposit (Double value) {
		this.balance += value;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void withDraw (Double value) throws DomainException{
		if (value > withdrawLimit) {
			throw new DomainException("O valor que se está tentando sacar é maior que o limite de saque da conta.");
		}
		if (value > balance) {
			throw new DomainException("Saldo insuficiente.");
		}
		this.balance -= value;
	}
	
	
	

}
