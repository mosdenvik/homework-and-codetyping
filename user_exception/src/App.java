package ua.org.oa.moskalenkod;

import java.util.Arrays;


public class App {

	public static void main(String[] args) throws StudentException {
		
		Group myGroup = new Group(5);
		myGroup.fillGroup();
		myGroup.printGroup();
	}

}
