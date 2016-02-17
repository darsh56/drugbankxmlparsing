

import java.io.File;
import java.util.Arrays;

public class folderallxmlfile {

	public static void main(String[] args) {
		File folder = new File("/home/local/EZDI/darsh.p/darshjava/final");
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		for(int i = 0; i < listOfFiles.length; i++){
		String filename = listOfFiles[i].getName();
		if(filename.endsWith(".xml")||filename.endsWith(".XML"))
		{
		System.out.println(filename);
		}
		   }
		  }
}
