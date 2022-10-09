package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Dictionary {
	
	public HashMap<String,String> readDict(){
		File file = new File("dictionary.txt");
		String str = "";
		HashMap<String,String> map = new HashMap<>();
		try(Scanner scan = new Scanner(file)) {
			while (scan.hasNextLine()) {
				str = scan.nextLine();
				String[] words = str.split(";");
				map.put(words[0],words[1]);
			}
			return map;
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void saveToDict(HashMap<String,String> map) {
		try(FileWriter file = new FileWriter("dictionary.txt", true)) {
			for(Map.Entry<String,String> word: map.entrySet()) {
				file.write(word.getKey() + ";" + word.getValue() + System.lineSeparator());
			}
			file.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Data saved to dictionary successfully");
	}
	
	public void inputDataToDict() {
		HashMap<String, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 'EXIT' for exit");
			System.out.println("enter a word in english");
			String engWord = sc.nextLine();
			if (engWord.equals("EXIT")) break;
			System.out.println("enter the Ukrainian translation");
			String ukrWord = sc.nextLine();
			if (engWord != "" && ukrWord != "") map.put(engWord, ukrWord);
		}
		saveToDict(map);
	}
}
