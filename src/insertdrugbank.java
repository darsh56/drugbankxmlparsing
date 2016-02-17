

import java.io.*;

public class insertdrugbank {
	

	public static void main(String [] args) throws IOException
	 {
		 
		 
		
		File fin = new File("TempDrugXml.xml");
	    FileInputStream fis = new FileInputStream(fin);
	    BufferedReader in = new BufferedReader(new InputStreamReader(fis));

	    
	    
	    File folder = new File("/home/local/EZDI/darsh.p/darshjava/final");
		File[] listOfFiles = folder.listFiles();
	    
	    
	    
	    FileWriter fstream = new FileWriter("kk.xml", true);
	    BufferedWriter out = new BufferedWriter(fstream);

	    String aLine = null;
	  out.write("<drugbank>");  
	    while ((aLine = in.readLine()) != null) {
	  	    	
	        out.write(aLine);
	        out.newLine();
	    }
	    out.write("</drugbank>");  
	   
	    in.close();

	   
	    out.close();
		 
	 }

}
