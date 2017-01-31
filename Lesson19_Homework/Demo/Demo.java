package homework;

public class Demo {

	public static void main(String[] args) {
		
		AllWork allwork = new AllWork();
		allwork.addTask(new CalculationTask("Calculating procject 1", 4));
		allwork.addTask(new CalculationTask("Calculating procject 2", 7));
		allwork.addTask(new CalculationTask("Calculating procject 3", 10));
		allwork.addTask(new PrintingTask("Printing project 1", 3));
		allwork.addTask(new PrintingTask("Printing project 2", 2));
		allwork.addTask(new PrintingTask("Printing project 3", 4));
		allwork.addTask(new PrintingTask("Printing project 4", 2));
		allwork.addTask(new DrawingTask("Drawing parking 1", 6));
		allwork.addTask(new DrawingTask("Drawing parking 2", 7));
		allwork.addTask(new DrawingTask("Drawing parking 3", 8));
		
		
		Employee.setAllwork(allwork);
		
		Employee[] employees = new Employee[3];
		employees[0] = new Employee("Pesho");
		employees[1] = new Employee("Gosho");
		employees[2] = new Employee("Martin");
		
        int countDays = 0;
		
		while(true){
			countDays++;
			System.out.println("\nDay " + countDays + " starts!\n");
			for (int i = 0; i < employees.length; i++) {
				if(employees[i] != null){
					employees[i].work();
				}
			}			 			 
			if(Employee.getAllWork().isAllWorkDone()){
				break;
			}
		}
        System.out.println("\nAll tasks finished for: " + countDays + " days!");				
	}
}
