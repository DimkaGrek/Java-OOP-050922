package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Group {
	private String groupName;
	private ArrayList<Student> students = new ArrayList<>();

	public Group(String groupName) {
		super();
		this.groupName = groupName;
		// this.students = students;
	}

	public Group() {
		super();
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (students.size() > 10) throw new GroupOverflowException("The group is overflow");
		else {
			student.setGroupName(this.groupName);
			students.add(student);
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for(Student student : students) {
			if (student.getLastName().equals(lastName)) return student;
		}
		throw new StudentNotFoundException("This student does not exist");
	}

	public boolean removeStudentById(int id) {
		for(Student student : students) {
			if (student.getId()==id) {
				students.remove(student);
				return true;
			}
		}
		return false;
	}
	
	public void sortStudentsByLastName() {
		Collections.sort(students, new LastNameComparator());
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		String result = groupName + System.lineSeparator();
		for (Student student: students) {
			result += student + System.lineSeparator();
		}
		return result;
	}
}
