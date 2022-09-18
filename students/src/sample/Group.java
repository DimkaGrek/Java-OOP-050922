package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] students = new Student[10];

	public Group(String groupName) {
		super();
		this.groupName = groupName;
		// this.students = students;
	}

	public Group() {
		super();
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				student.setGroupName(this.groupName);
				return;
			}
		}
		throw new GroupOverflowException("The group is overflow");

	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName() == lastName)
					return students[i];
			}
		}
		throw new StudentNotFoundException("This student does not exist");
	}

	public boolean removeStudentById(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsLast(new LastNameComparator()));
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		String result = groupName + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				result += students[i] + System.lineSeparator();
			}
		}
		return result;
	}
}
