
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler{

	List myEmpls;
	
	private String tempVal;
	private String director_name;
	
	//to maintain context
	private Directors tempEmp;
	
	
	public SAXParserExample(){
		myEmpls = new ArrayList();
	}
	
	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse("mains243.xml", this);
			
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){
		
		System.out.println("No of directors '" + myEmpls.size() + "'.");
		
		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
		System.out.println(it.next().toString());
		}
	}
	

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("directorfilms")) {
			//System.out.println("I entered directorfilms start element");
			//create a new instance of employee
			//tempEmp = new Directors();
			//tempEmp.setType(attributes.getValue("type"));
		}
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("I entered the end element handler");
		if(qName.equalsIgnoreCase("directorfilms")) {
			//add it to the list
			//myEmpls.add(tempEmp);
			
		}else if (qName.equalsIgnoreCase("dirname")) {
			director_name = new String(tempVal);
			//tempEmp.setName(tempVal);
		}else if (qName.equalsIgnoreCase("t")) {
			tempEmp = new Directors();
			tempEmp.setName(director_name);
			tempEmp.setTitle(tempVal);
		}else if(qName.equalsIgnoreCase("year")){
			tempEmp.setYear(tempVal);
		}else if(qName.equalsIgnoreCase("cat")){
			tempEmp.setCategory(tempVal);
			//WritetoDB(tempEmp);
			myEmpls.add(tempEmp);
		}
	
	}
	
	//Function to parse elements of tempEmp and write to DB
	
	public static void main(String[] args){
		SAXParserExample spe = new SAXParserExample();
		spe.runExample();
	}
	
}



