package homework;

public class AllWork {
	
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork(){
		this.freePlacesForTasks = 10;
		this.currentUnassignedTask = 0;
		tasks = new Task[this.freePlacesForTasks];
	}
	
	public void addTask(Task task){
		if (freePlacesForTasks > 0) {
			tasks[tasks.length - freePlacesForTasks] = task;
			freePlacesForTasks--;
		}else{
			System.out.println("You can't add more tasks");
		}			 		
	} 
	public Task getNextTask(){
		if (this.currentUnassignedTask < this.tasks.length) {
			return tasks[this.currentUnassignedTask++];	
		}else{			
			return null;
		}		 	
	}
	public boolean isAllWorkDone(){
		for (int i = 0; i < this.tasks.length; i++) {
			if (this.tasks[i].getWorkingHours() > 0 && this.tasks[i] != null) {				
				return false;
			}
		}
		return true;
	}
	
	void setTaskHours(Task task, int hours){
		for (int i = 0; i < tasks.length; i++) {
			if(tasks[i] == task && tasks[i] != null){
				tasks[i].setWorkingHours(hours);
			}
		}
}
}
