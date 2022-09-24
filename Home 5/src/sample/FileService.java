package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {

	public static long copyFile(File fileIn, File fileOut) throws IOException {
		try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
			return is.transferTo(os);
		}
	}
	
	public static int copyFileFromFolder(File folderIn, File folderOut) throws IOException{
		int count=0;
		if (folderIn.isDirectory() && folderOut.isDirectory()) {
			for (File item:folderIn.listFiles()) {
				if(!item.isDirectory()) {
					File toFile = new File(folderOut.getName() + "/" + item.getName());
					copyFile(item, toFile);
					count++;
				}
			}
		}
		return count;
	}
	
	public static int copyFileFromFolder(File folderIn, File folderOut, String ext) throws IOException{
		int count=0;
		if (folderIn.isDirectory() && folderOut.isDirectory()) {
			for (File item:folderIn.listFiles()) {
				if(!item.isDirectory() && getFileExtension(item).equals(ext)) {
					File toFile = new File(folderOut.getName() + "/" + item.getName());
					copyFile(item, toFile);
					count++;
				}
			}
		}
		return count;
	}
	
	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) 
			return fileName.substring(fileName.lastIndexOf(".")+1);
		else return "";
	}
}
