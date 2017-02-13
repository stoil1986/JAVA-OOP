

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import bank.Bank;
import bankAccount.HomeCredit;
import bankAccount.LongDeposit;
import bankAccount.ShortDeposit;
import client.Client;
import bankAccount.ConsumerCredit;

public class Demo {

	public static void main(String[] args) {
		
		ShortDeposit shortDeposit = new ShortDeposit(3, 3);
		LongDeposit longDeposit = new LongDeposit(5, 12);
		HomeCredit homeCredit = new HomeCredit(6, 24);
		ConsumerCredit consumerCredit = new ConsumerCredit(10, 32);
		
		Bank fiBank = new Bank("Fibank", "Mladost 4", 100000);
		fiBank.showBankInfo();
		ArrayList<Client> clients = new ArrayList<>();
		double m = new Random().nextInt(4000) + 3000.0; 
		double s = new Random().nextInt(1000) + 800.0;
		for (int i = 0; i < 10; i++) {
			clients.add(new Client("Pesho" + (i + 1), "Lulin" + (i + 1), m , s));
		}
		
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).makeDeposit(fiBank);
		}
		fiBank.showBankInfo();
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).getCredit(fiBank);;
		}
		fiBank.showBankInfo();
		for (int i = 0; i < clients.size(); i++) {
			System.out.println(clients.get(i));
		}		 
	}
}
