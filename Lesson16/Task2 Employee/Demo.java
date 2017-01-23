package homework2;

public class Demo {

	public static void main(String[] args) {
		
		Task welding = new Task("Welding", 6);
		Employee gosho = new Employee("Gosho");
		System.out.println(gosho.getName());
			    
		gosho.setHoursLeft(5);
		gosho.setCurrentTask(welding);
		gosho.Work();
		gosho.showReport();
		
		Task washing = new Task("Washing", 3);
		Employee vasilka = new Employee("Vasilka");
		vasilka.setHoursLeft(7);
		vasilka.setCurrentTask(washing);
		vasilka.Work();
		vasilka.showReport();
	}

}
