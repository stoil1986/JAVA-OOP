package bankAccount;

import java.util.Random;

public class LongDeposit extends Deposit {
		 
	private static final String DEPOSIT_NAME = "Long deposit";
	
	public LongDeposit(double interestRate, int period) {
		super(interestRate, period);
		super.setName(DEPOSIT_NAME);
		super.setPaidSum(new Random().nextInt(5) + 10.0);
	}
}
