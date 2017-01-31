package homework;

public class Employee {

	private String name;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork allwork;

	public Employee(String name) {
		setName(name);
		this.setHoursLeft(8);
		this.currentTask = allwork.getNextTask();
		//System.out.println("Employee " + this.name + " is working on " + this.currentTask.getName());
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

	public static AllWork getAllWork() {
		return allwork;
	}

	public static void setAllwork(AllWork allwork) {
		Employee.allwork = allwork;
	}

	public void startWorkDay() {
		this.hoursLeft = 8;
	}

	public void work() {
		if (this.getCurrentTask() == null) {
			return;
		}
		System.out.println("Employee " + "(" + this.name + ")" + " works on " + this.currentTask.getName());
		int taskHours = this.currentTask.getWorkingHours();
		taskHours -= this.getHoursLeft();
		if (taskHours > 0) {
			this.currentTask.setWorkingHours(taskHours);
			this.allwork.setTaskHours(currentTask, taskHours);
			this.hoursLeft = 0;
			
		} else {
			this.currentTask.setWorkingHours(0);
			this.hoursLeft = Math.abs(taskHours);
			this.allwork.setTaskHours(currentTask, 0);
			if (!allwork.isAllWorkDone()) {
				this.currentTask = allwork.getNextTask();
				System.out.println("Employee " + "(" + this.name + ")" + " gets new task.");
				work();
			}
		}
		this.startWorkDay();		 
	}

	

}
