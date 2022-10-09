package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {
	
	public String readEnglishText(File file) {
		String str = "";
		try(Scanner scan = new Scanner(file)) {
			while (scan.hasNextLine()) {
				str += scan.nextLine();
			}
			return str;
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void saveUkrText(String filename, String str) {
		try(FileWriter file = new FileWriter(filename)) {
			file.write(str);
			file.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("File saved successfully");
	}
}
