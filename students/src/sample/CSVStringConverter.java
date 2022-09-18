package sample;

public class CSVStringConverter implements StringConverter {

	@Override
	public String toStringRepresentation(Student student) {
		return student.getName() + ";" + student.getLastName() + ";" + student.getGender() + ";" + student.getId() + ";"
				+ student.getGroupName();
	}

	@Override
	public Student fromStringRepresentaion(String str) {
		Student student = new Student();
		String[] subStr = str.split(";");
		student.setName(subStr[0]);
		student.setLastName(subStr[1]);
		try {
			student.setGender(Gender.valueOf(subStr[2]));
		} catch (IllegalArgumentException e) {
			System.out.println("input string: '" + str + "'" + System.lineSeparator()
					+ "Wrong gender! Please, type MALE or FEMALE");
			return null;
		}
		try {
			student.setId(Integer.parseInt(subStr[3]));
		} catch (NumberFormatException e) {
			System.out.println("input string: '" + str + "'" + System.lineSeparator() 
					+ "Wrong id. 'id' must be a number");
			return null;
		}
		student.setGroupName(subStr[4]);
		return student;
	}
}
