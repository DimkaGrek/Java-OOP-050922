package sample;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
//		File fileIn = new File("/Users/dmytrozinkovskyi/Documents/ФОТО/IMG_0038_614x461.JPG");
//		File fileOut = new File(fileIn.getName());
//		
//		try {
//			System.out.println(FileService.copyFile(fileIn, fileOut)+" bytes copy");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		File folderIn = new File("/Users/dmytrozinkovskyi/Documents/1");
		File folderOut = new File("copyFolder");
		
		try {
			System.out.println("Copied " + FileService.copyFileFromFolder(folderIn, folderOut,"csv") + " files");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
