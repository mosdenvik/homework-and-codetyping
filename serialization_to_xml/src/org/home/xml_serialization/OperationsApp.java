package org.home.xml_serialization;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class OperationsApp {
	
	public static final String PACKAGE = DataObject.class.getPackage().getName();

	public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException{

		DataObject dataObj = new DataObject();
		dataObj.setData("Add new data");
		File file = new File("file.xml");
		
		JAXBContext jc = JAXBContext.newInstance(PACKAGE);
		
		Marshaller m = jc.createMarshaller();
		Unmarshaller um = jc.createUnmarshaller();
		
		m.marshal(dataObj, file);
		DataObject obj = (DataObject) um.unmarshal(file);
		System.out.println(obj);
	}

}
