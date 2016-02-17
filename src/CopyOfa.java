

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class CopyOfa {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File folder = new File("/home/local/EZDI/darsh.p/darshjava/final");
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		
		
		FileWriter writer = new FileWriter("drugbank.csv");
		writer.append("name");
		writer.append('\t');
		writer.append("indication");
		writer.append('\t');
		writer.append("catagories");
		writer.append('\t');
		writer.append("synonyms");
		writer.append('\n');
		writer.close();
		
		for(int i = 0; i < listOfFiles.length; i++)
		{
		  String filename = listOfFiles[i].getName();
		  if(filename.endsWith(".xml")||filename.endsWith(".XML"))
		  {
		   x2 x=new x2();
		   x.s(filename);
		   }
		 }
	
		
	}
}
