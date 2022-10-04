package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Task 1
		randomList();
		
		// Task 3
		File file = new File("english-text.txt");
		ArrayList<Character> chars = new ArrayList<>();
		String str = "";
		
		try(Scanner scan = new Scanner(file)) {
			while (scan.hasNextLine()) {
				str += scan.nextLine();
			}
			System.out.println(str);
			str = str.replaceAll("[^A-Za-z0-9]", "");
			System.out.println(str);
			for (char c: str.toCharArray()) {
				chars.add(c);
			}
			System.out.println(chars);
			Collections.sort(chars);
			System.out.println(chars);
			
			HashMap<Character, Integer> map = new HashMap<>();
			char currChar = chars.get(0);
			map.put(currChar, Collections.frequency(chars, currChar));
			for(char c: chars) {
				if (c != currChar) {
					currChar = c;
					map.put(currChar, Collections.frequency(chars, currChar));
				}
			}
			System.out.println(map);
			map.entrySet().stream()
	        .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()) 
	        .forEach(System.out::println);
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		// Task 4
		ArrayList<String> people = new ArrayList<String>();
		people.add("Sheldon");
		people.add("Leonard");
		people.add("Volovitc");
		people.add("Kutrapalli");
		people.add("Penny");
		System.out.println(people);
		int cola = 7;
		String cloneMan = "";
		for (int i=0; i<cola; i++) {
			cloneMan = people.remove(0);
			people.add(people.size(), cloneMan);
			people.add(people.size(), cloneMan);
		}
		System.out.println(people);
	}
	
	public static void randomList() {
		ArrayList<Integer> randList = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			randList.add((int) (Math.random()*100));
		}
		System.out.println(randList);
		randList.remove(0);
		randList.remove(0);
		randList.remove(randList.size() - 1);
		System.out.println(randList);
	}

}
