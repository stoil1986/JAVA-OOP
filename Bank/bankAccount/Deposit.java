package bankAccount;

public abstract class Deposit extends BankAccount {
	
	public Deposit(double interestRate, int period) {
		super(interestRate, period);
		
	}
	public void setPaidSum(double paidSum) {
		this.paidSum = paidSum;
	}
	private double paidSum;
		
	@Override
	public String toString() {
		return "Deposit [paidSum=" + paidSum + "]";
	}
	
	
		
}
