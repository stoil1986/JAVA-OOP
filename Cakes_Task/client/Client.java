package client;

import order.Order;
import shop.Shop;

public abstract class Client {
	
	private String name;
	private String phoneNumber;
	
	public Client(String name, String phoneNumber) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} 
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
	}
	
	public abstract int getDiscount();

	public abstract void makeOrder(Shop shop, Order order);
	

}
