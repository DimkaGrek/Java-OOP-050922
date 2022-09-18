package sample;

public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student("Ivan", "Ivanenko", Gender.MALE, 0, "");
		Student student2 = new Student("Vasil", "Vasilenko", Gender.MALE, 1, "");
		Student student3 = new Student("Vsevolod", "Volodenko", Gender.MALE, 2, "");
		Student student4 = new Student("Anna", "Anisenko", Gender.FEMALE, 3, "");
		Student student5 = new Student("Olga", "Olgienko", Gender.FEMALE, 4, "");
		Student student6 = new Student("Natalia", "Natalenko", Gender.FEMALE, 5, "");
		
		Group group1 = new Group("Group1");
		Group group2 = new Group("Group2");
		
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
		} catch (GroupOverflowException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(group1);
		
		try {
			System.out.println(group1.searchStudentByLastName("Olgienko"));
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		if (group1.removeStudentById(6)) System.out.println("The student removed");
		else System.out.println("Student does not exist");
		
		group1.sortStudentsByLastName();
		System.out.println(group1);
 	}

}
