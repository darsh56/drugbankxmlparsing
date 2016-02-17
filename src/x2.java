

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class x2 {

	public  void s(String filename) throws ParserConfigurationException,
			SAXException, IOException {
		// TODO Auto-generated method stub
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		String a11=filename;
		Document document = builder.parse(new File(a11));

		// Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

		// Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		NodeList nList = document.getElementsByTagName("drug");
		System.out.println("============================");
		FileWriter writer = new FileWriter("drugbank.csv",true);
		//writer.append("name");
		//writer.append('\t');
		
		//writer.append("indication");
		//writer.append('\t');
		//writer.append("catagories");
		//writer.append('\t');
		//writer.append("synonyms");
		//writer.append('\n');

		for (int i = 0; i < nList.getLength(); i++) {

			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// Print each employee's detail
				Element eElement = (Element) node;

				if (eElement.getElementsByTagName("group").item(0).getTextContent().equalsIgnoreCase("approved"))
				{
					System.out.println("1");

					writer.append(eElement.getElementsByTagName("name").item(0).getTextContent());
					writer.append('\t');
					//System.out.print(eElement.getElementsByTagName("indication").item(0).getTextContent().replace("\n"," "));
				 String d= eElement.getElementsByTagName("indication").item(0).getTextContent();
			//	 String r=d.replace('\n',' ');
				 String r= d.replaceAll("(\r\n|\n)"," ");
				 writer.append(r);
					writer.append('\t');
				

					System.out.println(" Name : " +
					 eElement.getElementsByTagName("name").item(0).getTextContent());

			 System.out.println("description Name : " +
					 eElement.getElementsByTagName("description").item(0).getTextContent());
					 System.out.println("indication : " +
					 eElement.getElementsByTagName("indication").item(0).getTextContent());

					NodeList nl = node.getChildNodes(); // drug na child list

					// catagories mate

					for (int t1 = 0; t1 < nl.getLength(); t1++) {
						Node tem1 = nl.item(t1);
						if (tem1.getNodeName().equalsIgnoreCase("categories")) {

							Element eElement3 = (Element) nl;
							NodeList nList2 = eElement3.getElementsByTagName("categories");
							System.out.println("============================");
						HashSet<String> outPutData=	  visitChildNodescategories(nList2);
				          java.util.Iterator<String> itrData = outPutData.iterator();
				          
				          while (itrData.hasNext()) {
							String value = (String) itrData.next();
							System.out.println(value);
					writer.append(value.trim());
									writer.append("****spec****");
						}
				      			  	writer.append('\t');
						}
					}

					// synonm mate

					for (int t = 0; t < nl.getLength(); t++) // drug na child
																// list ne node
																// ma
					{
						Node tem = nl.item(t);
						if (tem.getNodeName().equalsIgnoreCase("synonyms"))
						{

							NodeList nlp = (NodeList) tem.getChildNodes();
							System.out.println("synonms");
							int a = 0;
							for (int q = 0; q < 2; q++) 
							{
								Node tempo = nlp.item(q);
                         if(nlp.getLength()>0)
                         {	
                        	 if (tempo.getNodeType() == Node.ELEMENT_NODE)
								{

									Element eElement3 = (Element) nlp;

									while (a < eElement3.getElementsByTagName("synonym").getLength())
									{

										System.out.println("synonym: "+ eElement3.getElementsByTagName("synonym").item(a).getTextContent());
									writer.append(eElement3.getElementsByTagName("synonym").item(a).getTextContent());
										writer.append("****spec****");
										a++;
									}// synonm length

								}// tempo.getNodeType() == Node.ELEMENT_NODE
								
                         }
                         else
                         {
                        	 
                         }
							} // synonms na child list ne node ma

						}// synnms lidho

					}// drug na child list ne node ma

					writer.append('\n');

				} // end if condtion of group vali
				else

				{

				}

			}// end of if (node.getNodeType() == Node.ELEMENT_NODE)

		} // end of main for loop
		writer.close();

	}

	static HashSet<String> visitChildNodescategories(NodeList nList)
	   {
		HashSet<String> data = new HashSet<String>();
		  String[] parts = null ;
		  int g=0;
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	    	  
	    	  System.out.println(nList.getLength());
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            System.out.println(node.getNodeName());
	            String d=node.getTextContent();
			     
	      
	          
		          parts = d.split("\n");
		         for( g=2;g<parts.length;g=g+4)
		         {
		        	 data.add(parts[g]);
		           	//System.out.println(parts[g]+"=Stringcatagory"+g);  
		        	 
		        	// System.out.println("Stringcatagory"+g+"="+parts[g]);
		       
		        	 
		         } 
	               
	         }
	      }
		return data;
	

		
		
	   }
}
