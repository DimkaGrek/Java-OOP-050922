package sample;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student("Ivan", "Ivanenko", Gender.MALE, 0, "");
		Student student2 = new Student("Vasil", "Vasilenko", Gender.MALE, 1, "");
		Student student3 = new Student("Vsevolod", "Volodenko", Gender.MALE, 2, "");
		Student student4 = new Student("Anna", "Anisenko", Gender.FEMALE, 3, "");
		Student student5 = new Student("Olga", "Olgienko", Gender.FEMALE, 4, "");
		Student student6 = new Student("Natalia", "Natalenko", Gender.FEMALE, 5, "");
		
		InputStudent add = new InputStudent();
		Student student7 = add.inputStudent();
		
		Group group1 = new Group("Group1");
		
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
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
		
		CSVStringConverter convert = new CSVStringConverter();
		
		System.out.println(convert.toStringRepresentation(student7));
		System.out.println(convert.fromStringRepresentaion("Dmytro;Zinkovskyi;MALE;8;Group1"));
		
		GroupFileStorage grStorage = new GroupFileStorage();
		grStorage.saveGroupToCSV(group1);
		
		File file = new File("Group1.csv");
		
		System.out.println(grStorage.loadGroupFromCSV(file));
		File folder = new File("/Users/dmytrozinkovskyi/JavaProjects/Java-OOP-050922/Students");
		try {
			if (grStorage.findFileByGroupName(group1.getGroupName(), folder) != null) {
				System.out.println("File exists");
			}
			else System.out.println("File is not exist");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
 	}

}
