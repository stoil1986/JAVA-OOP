package shop;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

import cake.Cake;
import cake.Cake.IType;
import cake.KidsCake.KidsType;
import cake.SpecialCake.SpecialType;
import cake.StandartCake.StandartType;
import supplier.Supplier;


public class Shop {
	
	private String name;
	private String address;
	private String phoneNumber;
	private double cash;
	private HashMap<String, HashMap<IType,TreeSet<Cake>>> catalog;
	private ArrayList<Supplier> suppliers;
	
	public Shop(String name, String address, String phoneNumber, double cash) {

		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (address != null && !address.isEmpty()) {
			this.address = address;
		}
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
		if (cash > 0) {
			this.cash = cash;
		}
		this.catalog = new HashMap<>();
		this.suppliers = new ArrayList<>();
	}
	
	public void addCakes(Cake cake){
		String kind = cake.getKind();
		IType type = cake.getType();
		if (!this.catalog.containsKey(kind)) {
			this.catalog.put(kind, new HashMap<>());			
		}
		if (!this.catalog.get(kind).containsKey(type)) {
			this.catalog.get(kind).put(type, new TreeSet<Cake>());
		}
		this.catalog.get(kind).get(type).add(cake);
	}
	
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
		
	public boolean removeCake(Cake cake){
		String kind = cake.getKind();
		IType type = cake.getType();
		if (this.catalog.containsKey(kind)){
			if (this.catalog.get(kind).containsKey(type)) {
				TreeSet<Cake> cakes =  this.catalog.get(kind).get(type);
				cakes.removeIf(x-> x.getPrice() == cake.getPrice());
				return true;
			}
		}
		return false;
	}
	
	public Cake getRandomCake(String randKind, IType randType){
		if (this.catalog.containsKey(randKind)){
			if (this.catalog.get(randKind).containsKey(randType)) {
				TreeSet<Cake> cakes =  this.catalog.get(randKind).get(randType);
				for (Iterator it = cakes.iterator(); it.hasNext();) {
					Cake cake = (Cake) it.next();
					it.remove();  
					return cake;
				}
			}
		}
		return null;		
	}
		
	public void printCakes(){
		for (Iterator<Entry<String, HashMap<IType, TreeSet<Cake>>>> iterator = catalog.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, HashMap<IType, TreeSet<Cake>>> e = iterator.next();
			System.out.println("------------ " + e.getKey() + " cake -----------");
			HashMap<IType, TreeSet<Cake>> cakes = e.getValue();
			for (Iterator<Entry<IType, TreeSet<Cake>>> it = cakes.entrySet().iterator(); it.hasNext();) {
				Entry<IType, TreeSet<Cake>> e1 =  it.next();
				System.out.println(e1.getKey() + ":");
				TreeSet<Cake> set = e1.getValue();
				for (Cake cake : set) {
					System.out.println("    Price: " + cake.getPrice() + "  Number of pieces: " + cake.getPieceCount() + ".");
				}
							
			}
		}
	}
	
	public Supplier getRandomSupplierToBringOrder(){		
		return suppliers.get(new Random().nextInt(suppliers.size()));
	}
	
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

//	public List<Supplier> getSuppliers() {
//		return Collections.unmodifiableList(suppliers);
//	}
}
