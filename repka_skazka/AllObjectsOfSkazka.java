package repka_skazka;

import java.util.ArrayList;

public class AllObjectsOfSkazka {
	
	static ArrayList<Object> allObjects = new ArrayList<Object>();

	static int generalPowerOfAllObjects = countPowerOfHuman() + countPowerOfAnimal();
		
	public static int countPowerOfHuman(){
		int generalPower = 0;
		for (Object ob : allObjects) {
			generalPower += (((Human) ob).getPowerOfTakingRepka());
		}
		return generalPower;
	}
	
	public static int countPowerOfAnimal(){
		int generalPower = 0;
		for (Object ob : allObjects) {
			generalPower += ((Animal) ob).getPowerOfTakingRepka();
		}
		return generalPower;
	}
	
		
	public static void addObject(Object addingObject) {
		allObjects.add(addingObject);
	}
	
	

}
