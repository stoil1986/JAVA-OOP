package bankAccount;

import java.util.Random;

public class HomeCredit extends Credit {
	
	private static final String CREDIT_NAME = "Home credit";

	public HomeCredit(double interestRate, int period) {
		super(interestRate, period);
		super.setName(CREDIT_NAME);
		super.setPayment(new Random().nextInt(200) + 200);		
	}
	
	
}
