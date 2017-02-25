package order;

import java.util.ArrayList;

import cake.Cake;
import client.Client;

public class Order {
	
	private double price;
	private String address;
	private ArrayList<Cake> orderCakes;
	
	public Order(String address) {		
		this.price = 0; 
		if (address != null && !address.isEmpty()) {
			this.address = address;
		} 				 
		this.orderCakes = new ArrayList<>();
	}
	
	public void addCakeToOrder(Cake cake){
		this.orderCakes.add(cake);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
