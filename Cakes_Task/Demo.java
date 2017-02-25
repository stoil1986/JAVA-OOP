import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

import cake.KidsCake;
import cake.SpecialCake;
import cake.StandartCake;
import cake.WeddingCake;
import client.Client;
import client.CorporateClient;
import client.PrivateClient;
import order.Order;
import shop.Shop;
import supplier.Supplier;

public class Demo {

	public static void main(String[] args) {

		Shop shop = new Shop("Sweet talants", "Mladost 4", "0883452222", 2000);

		String[] names = { "Pesho", "Gosho", "Stoil", "Kolio", "Dancho", "Ivan"};

		ArrayList<Supplier> suppliers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String randName = names[new Random().nextInt(names.length)];
			suppliers.add(new Supplier(randName, "088445652" + i));
		}

		shop.setSuppliers(suppliers);

		for (int i = 0; i < 30; i++) {

			double randPrice = new Random().nextInt(50) + 100;
			int randPieces = new Random().nextInt(20) + 30;

			int chance = new Random().nextInt(4);
			if (chance == 0) {
				shop.addCakes(new WeddingCake("For wedding", "Special for Pesho's wedding", randPrice, randPieces, 5));
			} else if (chance == 1) {
				shop.addCakes(new SpecialCake("Garash", "very delicious", randPrice, randPieces, "Birtday"));
			} else if (chance == 2) {
				shop.addCakes(new KidsCake("Fruit", "with so much fruit", randPrice, randPieces, "Pesho junior"));
			} else if (chance == 3) {
				shop.addCakes(new StandartCake("Cream", "Chocolade", randPrice, randPieces));
			}
		}

		ArrayList<Client> clients = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			String randName = names[new Random().nextInt(names.length)];
			clients.add(new CorporateClient(randName, "088765655" + i));
			clients.add(new PrivateClient(randName, "088765644" + i));
		}
		System.out.println("====== Cakes available in store before making orders ====== \n");
		shop.printCakes();

		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).makeOrder(shop, new Order("Lulin " + i));
		}

		System.out.println("\n======= Cakes available in store after making orders =======\n");
		shop.printCakes();

		System.out.println("\nCash in store: " + shop.getCash());

		ArrayList<Supplier> supps = shop.getSuppliers();

		supps.sort(new Comparator<Supplier>() {

			@Override
			public int compare(Supplier s1, Supplier s2) {
				if (s1.getBakshish() - s2.getBakshish() > 0) {
					return 1;
				}
				if (s1.getBakshish() - s2.getBakshish() < 0) {
					return -1;
				}
				return 0;

			}
		});
		
		System.out.println("\n--------- Suppliers sorted by bakshish -----------");
		supps.forEach(x -> System.out.println(x.getName() + " " + x.getBakshish()));

	}
}
