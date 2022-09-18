package sample;

import java.util.Comparator;

public class LastNameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Student student1 = (Student) o1;
		Student student2 = (Student) o2;
		
		if(student1.getLastName().compareTo(student2.getLastName()) > 0) {
			return 1;
		}
		
		if(student1.getLastName().compareTo(student2.getLastName()) < 0) {
			return -1;
		}
		
		return 0;
	}
	
	
}
