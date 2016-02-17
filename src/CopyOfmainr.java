

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyOfmainr {
	public static void main(String [] args) throws IOException
	 {
		File fin = new File("drugbank.xml");
	    FileInputStream fis = new FileInputStream(fin);
	    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
	    String aLine=null; 
	    int fileNumber=0;
	    int a=0;
	    BufferedWriter out=null;
	    
	   
	   
	    while ((aLine = in.readLine()) != null) {
	    	
	    	FileWriter fstream = new FileWriter(fileNumber+".xml", true);
	  		 out = new BufferedWriter(fstream);
	    	out.write(aLine);
		    out.newLine();
		    
		    System.out.println(aLine);
			
			
	    	 if(aLine.equals("</drug>"))
	    			 
		    	{
	    			
			a++; 
			if(a==250)
			{
				a=0;
				fileNumber++;
			}
		  }   	
	    	
	 	    out.close();

	    }
	    in.close();

		   
	    
	 
	 }
	
}
