package org.home.xml_serialization;

import java.io.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name="dataObj")

public class DataObject extends NonSerializable {
	
	@XmlElement(required = true, name = "i")
	int i = 5;

	@XmlElement(required = true, name = "s")
	String s = "aaa";
	
	transient String[] def = { "AAA", "BBB", "CCC" };
	
	@XmlElement(required = true)
	CustomObject customObject = new CustomObject();

	

	@Override
	public String toString() {
		return "DataObject [i=" + i + ", s=" + s + ", customObject="
				+ customObject + "]";
	}

}
