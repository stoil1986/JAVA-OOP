package bankAccount;

import java.util.Random;

public class ConsumerCredit extends Credit {
	
	private static final String CREDIT_NAME = "Consumer credit";
	
	public ConsumerCredit(double interestRate, int period) {
		super(interestRate, period);
		super.setName(CREDIT_NAME);
		super.setPayment(new Random().nextInt(100) + 200);
	}
}
