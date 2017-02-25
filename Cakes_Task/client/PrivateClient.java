package client;

import java.util.ArrayList;
import java.util.Random;

import cake.Cake;
import cake.Cake.IType;
import cake.KidsCake.KidsType;
import cake.SpecialCake.SpecialType;
import cake.StandartCake.StandartType;
import cake.WeddingCake.WeddingType;
import order.Order;
import shop.Shop;
import supplier.Supplier;

public class PrivateClient extends Client {

	private ArrayList<Integer> vouchers;
	private int maxNumberOfVoucher;
	
	public PrivateClient(String name, String phoneNumber) {
		super(name, phoneNumber);
		vouchers = new ArrayList<>();
		this.maxNumberOfVoucher = new Random().nextInt(4) + 1;		 
		for (int i = 0; i < maxNumberOfVoucher; i++) {
			int randValue = new Random().nextInt(21) + 10;
			vouchers.add(randValue);
		}				
	}

	@Override
	public int getDiscount() {		
		return 0;
	}

	@Override
	public void makeOrder(Shop shop, Order order) {
		
 		int rand = new Random().nextInt(3) + 1;
 		
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

		int totalSumOfVouchers = 0;
		for (Integer voucher : vouchers) {
			 totalSumOfVouchers += voucher;
		}		 
		double finalOrderPrice = order.getPrice() - totalSumOfVouchers;
		shop.setCash(shop.getCash() + finalOrderPrice);
		supplier.setBakshish(supplier.getBakshish() +  2.0/100*finalOrderPrice);				
	}	
}
