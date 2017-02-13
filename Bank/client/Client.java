package client;

import java.util.ArrayList;
import java.util.Random;

import bank.Bank;
import bankAccount.ConsumerCredit;
import bankAccount.Credit;
import bankAccount.Deposit;
import bankAccount.HomeCredit;
import bankAccount.LongDeposit;
import bankAccount.ShortDeposit;

public class Client {

	private String name;
	private String address;
	private double money;
	private double salary;
	private Deposit deposit;
	private ArrayList<Credit> credits;

	public Client(String name, String address, double money, double salary) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (address != null && !address.isEmpty()) {
			this.address = address;
		}
		if (money > 0) {
			this.money = money;
		}
		if (salary > 0) {
			this.salary = salary;
		}
		credits = new ArrayList<>();

	}

	public void makeDeposit(Bank bank) {
		if (this.money > 0) {
			double percent = (new Random().nextInt(21) + 80) / 100.0;
			double moneyForDeposit = percent * this.money;
			this.money -= moneyForDeposit;
			if (new Random().nextBoolean()) {
				this.deposit = new LongDeposit(6, 18);
			} else {
				this.deposit = new ShortDeposit(4, 6);
			}
			bank.setCash(bank.getCash() + moneyForDeposit);
			bank.setReserv(bank.getReserv() + 0.9 * moneyForDeposit);
			bank.addBankAccount(this.deposit);
		}
	} 

	public void getCredit(Bank bank) {
		double totalCreditTax = 0;
		// for (int i = 0; i < credits.size(); i++) {
		// totalCreditTax += credits.get(i).getPayment();
		// }
		while (totalCreditTax < 0.5 * this.salary) {
			totalCreditTax = 0;
			for (int i = 0; i < credits.size(); i++) {
				totalCreditTax += credits.get(i).getPayment();
			}
			if (new Random().nextBoolean()) {
				Credit credit = new HomeCredit(7, 10);
				this.credits.add(credit);
			} else {
				Credit credit = new ConsumerCredit(8, 16);
				this.credits.add(credit);
			}
			Credit lastCredit = this.credits.get(credits.size() - 1);

			if (bank.getCash() - lastCredit.getTotalSumOfCredit() > 0.1 * bank.reserv) {
				this.money += lastCredit.getTotalSumOfCredit();
				bank.setCash(bank.getCash() - lastCredit.getTotalSumOfCredit());
			} else {
				this.credits.remove(credits.size() - 1);
				System.out.println("You can't get more credits");
				break;
			}
		}
	}

	public ArrayList<Credit> getCredits() {
		return credits;
	}
		
	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", money=" + money + ", salary=" + salary
				+ ", deposit=" + deposit + ", credits=" + credits + "]";
	}
	
	

}
