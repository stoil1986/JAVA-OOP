package bankAccount;

public abstract class BankAccount {

	private String name;
	private double interestRate;
	private int period;
	private double accountBalance;
		
	public BankAccount(double interestRate, int period) {
		if (interestRate > 0) {
			this.interestRate = interestRate;
		}
		if (period > 1 && period < 60) {
			this.period = period;	
		}		 	
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeriod() {
		return period;
	}

	
	
	
}
