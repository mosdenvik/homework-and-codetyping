package org.home.xml_serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)

public class NonSerializable {
	
	@XmlElement(required = true)
	private String data = "data from nonSerializable class";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
