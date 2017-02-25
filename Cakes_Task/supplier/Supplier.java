package supplier;

import java.util.HashSet;

import order.Order;

public class Supplier {
	
	private String name;
	private String phoneNumber;
	private HashSet<Order> orders;
	private double bakshish;
		 
	public Supplier(String name, String phoneNumber) {	
		this.bakshish = 0;
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
		orders = new HashSet<>();
	}
	
	public void addOrder(Order order){
		this.orders.add(order);
	}
	
	public void setBakshish(double bakshish) {
		this.bakshish = bakshish;
	}

	public String getName() {
		return name;
	}

	public double getBakshish() {
		return bakshish;
	}
		
}
