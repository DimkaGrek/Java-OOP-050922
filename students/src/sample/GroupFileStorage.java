package sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) {
		CSVStringConverter convert = new CSVStringConverter();
		ArrayList<Student> students = gr.getStudents();
		try(FileWriter file = new FileWriter(gr.getGroupName()+".csv")) {
			for (Student student : students) {
				file.write(convert.toStringRepresentation(student)+System.lineSeparator());
//				System.out.println(convert.toStringRepresentation(student));
			}
			file.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("File saved successfully");
	}
	
	public Group loadGroupFromCSV(File file) {
		String groupName = removeExtension(file.getName());
		Group gr = new Group(groupName);
		CSVStringConverter convert = new CSVStringConverter();
		try(Scanner scan = new Scanner(file)) {
			while (scan.hasNextLine()) {
				try {
					gr.addStudent(convert.fromStringRepresentaion(scan.nextLine()));
				} catch (GroupOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
//				System.out.println(scan.nextLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return gr;
	}
	
	private static String removeExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex != -1) {
            fileName = fileName.substring(0, lastIndex);
        }
        return fileName;
    }
	
	public File findFileByGroupName(String groupName, File workFolder) throws IOException {
		File filename = new File(groupName + ".csv");
		if(workFolder.isDirectory()) {
			for(File item:workFolder.listFiles()) {
				if (item.getName().equals(filename.getName())) return filename;
			}
		}
		return null;
			
	}
}
