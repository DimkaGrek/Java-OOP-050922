package sample;

import java.util.Scanner;

public class InputStudent {
	
	public Student inputStudent() {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's name:");
		student.setName(sc.nextLine());
		System.out.println("Input student's last name:");
		student.setLastName(sc.nextLine());
		System.out.println("Input student's gender (MALE or FEMALE):");
		while (true) {
			try {
				student.setGender(Gender.valueOf(sc.nextLine()));
				break;
			} catch(IllegalArgumentException e) {
				System.out.println("Wrong gender! Please, type MALE or FEMALE");
			}
		}
		System.out.println("Input student's id:");
		while (!sc.hasNextInt()) {
	        System.out.println("id must be a number!");
	        sc.next();
	    }
		student.setId(sc.nextInt());

		return student;
	}
}
