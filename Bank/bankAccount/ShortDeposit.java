package bankAccount;

import java.util.Random;

public class ShortDeposit extends Deposit {

	private static final String DEPOSIT_NAME = "Short deposit";
	
	public ShortDeposit(double interestRate, int period) {
		super(interestRate, period);
		super.setName(DEPOSIT_NAME); 	
		super.setPaidSum(new Random().nextInt(5) + 8.0);
	}
}
