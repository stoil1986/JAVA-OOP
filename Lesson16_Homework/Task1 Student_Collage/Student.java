package Homework1;

public class Student {
	
	String name;
	String subject;
	double grade;
	int yearInCollage;
	int age;
	boolean isDegree;
	double money;
	
	Student(){
		this.grade = 4.0;
		this.yearInCollage = 1;
		this.isDegree = false;
		this.money = 0;						
	}
	Student(String name,String subject, int age){
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	void upYear(){
		if (this.yearInCollage < 4 && this.yearInCollage > 0) {
			this.yearInCollage++;
			if (yearInCollage == 4) {
				isDegree = true;
			}
		}else {
			System.out.println("You can't change years! Тhe student has graduated!");
		}
	}
	double recieveScholarship(double min ,double amount){
		if (this.grade >= min && this.age < 30) {
			this.money += amount;
		}
		return this.money;
	}
}
