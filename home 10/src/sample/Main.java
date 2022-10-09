package sample;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// read dictionary
		Dictionary dictionary = new Dictionary();
		HashMap<String, String> dict = dictionary.readDict(); // формируем карту словаря
		Set<String> setKeys = dict.keySet(); // получаем множество ключей
		FileStorage file = new FileStorage();
		File engFile = new File("English.in");
		String engStr = file.readEnglishText(engFile);
		System.out.println(engStr);
		String ukrStr = "";
		String word = "";
		String[] notTranslate = {"a", "the", "to"};
		for (int i = 0; i < engStr.length(); i++) {
			if (engStr.charAt(i) == '.' || engStr.charAt(i) == ',' || engStr.charAt(i) == ' ') {
				if (Arrays.asList(notTranslate).contains(word)) {
					word = "";
				}
				else {
					if (word != "") {
						for(String str: setKeys) {
							if (str.equals(word)) {
								ukrStr += dict.get(str);
								word = "";
								break;
							}
						}
						if (word != "") {
							ukrStr += word;
							word = "";
						}
					}
					ukrStr += engStr.charAt(i);
				}
			}
			else word += engStr.charAt(i);
		}
		System.out.println(ukrStr);
		file.saveUkrText("Ukrainian.out", ukrStr);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to add a dictionary? (yes/no)");
		String answer = sc.nextLine();
		if (answer.equals("yes")) dictionary.inputDataToDict();
		else System.out.println("Goodbye, see you later");
	}
	
}
