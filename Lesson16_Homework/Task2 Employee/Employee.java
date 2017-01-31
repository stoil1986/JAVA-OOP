package homework2;

public class Employee {
	
	private String name;
	private Task currentTask;
	private int hoursLeft;
		
	public Employee(String name) {
		setName(name);
	}
			
	public String getName() {
		return name; 
	} 

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}		
	}
	
	
	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
		}		 
	}

	public int getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft >= 0 && hoursLeft <= 8) {
			this.hoursLeft = hoursLeft;
		} 		 
	}
	
	public void Work(){
		if (this.getCurrentTask() != null) {			

			int workingHours = this.getCurrentTask().getWorkingHours();
			workingHours -= this.getHoursLeft();
			if (workingHours > 0) {
				this.getCurrentTask().setWorkingHours(workingHours);
				this.setHoursLeft(0);
			}else {
				this.getCurrentTask().setWorkingHours(0);
				this.setHoursLeft(Math.abs(workingHours));
			}
		}		
	}
	
	public void showReport(){
		if (this.getCurrentTask() != null) {
			System.out.println("Name of the worker: " + this.getName()
	         + "\nName of the task: " + this.getCurrentTask().getName()
	         + "\nWorker hours left: " + this.getHoursLeft()
	         + "\nHours left to finish the work: " + this.getCurrentTask().getWorkingHours() + "\n");
		}		 
	}
}
