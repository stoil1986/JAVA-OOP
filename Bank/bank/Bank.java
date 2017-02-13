package bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import bankAccount.BankAccount;

public class Bank {
	
	private String name;
	private String address;
	private ArrayList<BankAccount> bankAccounts;
	private double cash;
	public double reserv;
	
	public Bank(String name, String address, double cash) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (address != null && !address.isEmpty()) {
			this.address = address;
		}
		if (cash > 0) {
			this.cash = cash;
		}
		this.bankAccounts = new ArrayList<>();	
	}
	
	public void showBankInfo(){
		System.out.println("Bank: " + this.name + " -->" + " Cash: " + this.cash + " Reserv: " + this.reserv);
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}	
	
	public double getReserv() {
		return reserv;
	}
	 
	public void setReserv(double reserv) {
		this.reserv = reserv;
	}
	
	public List<BankAccount> getBankAccounts() {
		return  Collections.unmodifiableList(bankAccounts);
	}

	public void addBankAccount(BankAccount bankAccount) {
		this.bankAccounts.add(bankAccount)	;	
	}
}
