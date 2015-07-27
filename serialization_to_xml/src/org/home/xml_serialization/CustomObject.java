package org.home.xml_serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CustomObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomObject {
	transient boolean b;

	@Override
	public String toString() {
		return "CustomObject [b=" + b + "]";
	}
	
	
}
