package client;

import java.util.Random;
import supplier.Supplier;

import cake.Cake;
import cake.Cake.IType;
import cake.KidsCake.KidsType;
import cake.SpecialCake.SpecialType;
import cake.StandartCake.StandartType;
import cake.WeddingCake.WeddingType;
import order.Order;
import shop.Shop;

public class CorporateClient extends Client{

	public CorporateClient(String name, String phoneNumber) {
		super(name, phoneNumber);		
	}

	@Override
	public int getDiscount() {
		int randDiscount = new Random().nextInt(11) + 5;
		return randDiscount;
	}

	@Override
	public void makeOrder(Shop shop, Order order) {
		
 		int rand = new Random().nextInt(3) + 3;
 		
		for (int i = 0; i < rand; i++) {
			
			String[] kinds = {"Kids","Special","Standart", "Wedding"};
			String randKind = kinds[new Random().nextInt(kinds.length)];
			IType randType;
			if (randKind == "Kids"){
				randType = KidsType.values()[new Random().nextInt(KidsType.values().length)];
			}else if(randKind == "Wedding"){
				randType = WeddingType.values()[new Random().nextInt(WeddingType.values().length)];
			}else if(randKind == "Special"){
				randType = SpecialType.values()[new Random().nextInt(SpecialType.values().length)];
			}else{
				randType = StandartType.values()[new Random().nextInt(StandartType.values().length)];
			}
						
			Cake randCake = shop.getRandomCake(randKind, randType);
			if (randCake != null) {
				double cakePrice = randCake.getPrice();
				order.addCakeToOrder(randCake);
				order.setPrice(order.getPrice() + cakePrice);
			}			
		}
		Supplier supplier = shop.getRandomSupplierToBringOrder();
		supplier.addOrder(order);
		double finalOrderPrice = order.getPrice() - order.getPrice()*this.getDiscount()/100.0;
		shop.setCash(shop.getCash() + finalOrderPrice);
		supplier.setBakshish(supplier.getBakshish() +  5.0/100*finalOrderPrice);				
	}		
}
