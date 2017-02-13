package bankAccount;

public abstract class Credit extends BankAccount {

	private double payment;
	
	public Credit(double interestRate, int period) {
		super(interestRate, period);
		
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getPayment() {
		return payment;
	}	
	
	public double getTotalSumOfCredit(){
		return this.payment*this.getPeriod();
	}

	@Override
	public String toString() {
		return "Credit [payment=" + payment + "]";
	}

	
	
	
}
