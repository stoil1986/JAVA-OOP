package Homework1;

public class StudentGroup {

	String groupSubject;
	Student[] students;
	int freeSpaces;
	
	StudentGroup() {
		this.students = new Student[5]; 
		this.freeSpaces = 5;
	}
	StudentGroup(String groupSubject) {
		this();
		this.groupSubject = groupSubject;
	}
	
	void addStudent(Student s){
		
		boolean isSameStudent = false;
		if (s != null && s.subject.equals(groupSubject) && freeSpaces > 0) {
			
			for (int i = 0; i < students.length; i++) {
				if (s == students[i]) {
					isSameStudent = true;
					break;
				}
			}
			if (!isSameStudent) {
				students[5-freeSpaces] = s;
				freeSpaces--;
				if (freeSpaces == 0) {
					System.out.println("This was the last student, you can't add more in this group!");
				}
			}else{
				System.out.println("This student is already added\n");
			}			  
		}else{
			System.out.println("The group is full or this student has different subject!");
		}
	}
	void emptyGroup(){
		this.students = new Student[5];
		freeSpaces = 5;
	}
	String theBestStudent(){
		double bestGrade = 0;
		String bestStudentName = "";
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null){
				if (students[i].grade > bestGrade) {
					bestGrade = students[i].grade;
					bestStudentName = students[i].name;
				}
			}			 
		}
		return bestStudentName;
	}
	
	void printStudentsInGroup(){
		
		boolean isEmpty = true;
		String graduate = "Not graduated";
		
		for (int i = 0; i < students.length; i++) {
 
			if (students[i] != null) {
				isEmpty = false;
				if (students[i].isDegree) {
					graduate = "Graduated";
				} 
				System.out.println("---Student " + (i+1) + "---" 
				          + "\nName : " + students[i].name 
				          + "\nSubject : " + students[i].subject 
				          + "\nGrade : " + students[i].grade
				          + "\nYear in collage: " + students[i].yearInCollage
				          + "\nAge: " + students[i].age					          
				          + "\nGraduated or not: " + graduate
				          + "\nMoney: " + students[i].money + "\n");
			}			
		}
		if (isEmpty) {
			System.out.println("Epmty group");
		}
	}	
}
