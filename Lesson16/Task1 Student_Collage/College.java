package Homework1;

public class College {

	public static void main(String[] args) {
		
		Student stoil = new Student("Stoil","Math",30);
		Student pesho = new Student("Pesho","Informathic",22);
		Student peshko = new Student("Peshko","Informathic",24);
		Student gosho = new Student("Gosho","Math",27);
		Student kiro = new Student("Kiril","Math",21);
		Student miro = new Student("Miro","Math",26);
		Student zoro = new Student("Zoro","Math",19);
		Student milenka = new Student("Milenka","Math",23);

		stoil.yearInCollage = 3;
		stoil.upYear();
		stoil.upYear();
		System.out.println(stoil.isDegree);
		System.out.println(stoil.yearInCollage);
		System.out.println(pesho.yearInCollage);
		pesho.recieveScholarship(3.0, 400);
		gosho.grade = 6.0;
		kiro.recieveScholarship(3.5, 500);
		kiro.upYear();
		
		System.out.println(pesho.money);
		 
		StudentGroup group1 = new StudentGroup("Math");
		group1.addStudent(gosho);
		group1.addStudent(kiro);
		group1.addStudent(stoil);
		group1.addStudent(miro);
		group1.addStudent(zoro);
		group1.addStudent(milenka);
 
		System.out.println(group1.theBestStudent());
		group1.printStudentsInGroup();
		
		StudentGroup group2 = new StudentGroup("Informathic");
		group2.addStudent(pesho);
		group2.addStudent(pesho);
		group2.addStudent(peshko);
		group2.printStudentsInGroup();
		group1.emptyGroup();
	}	
}
