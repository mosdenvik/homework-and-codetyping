package repka_skazka;

import java.util.ArrayList;
import java.util.List;

public class AllObjectsOfSkazka {
	
	 static List<Object> allObjects = new ArrayList<Object>();
	
	public static void addObject(Object addingObject) {
		allObjects.add(addingObject);
	}
	
		
	public static int countPowerOfHuman(){
		int generalPower = 0;
		for (Object ob : allObjects) {
			if(ob instanceof Human){
			generalPower += (((Human) ob).getPowerOfTakingRepka());
			}
		}
		return generalPower;
	}
	
	public static int countPowerOfAnimal(){
		int generalPower = 0;
		for (Object ob : allObjects) {
			if(ob instanceof Animal){
			generalPower += ((Animal) ob).getPowerOfTakingRepka();
			}
		}
		return generalPower;
	}
	
	static int generalPowerOfAllObjects(){ 
		return  countPowerOfHuman() + countPowerOfAnimal();
	}
	
	
	

}
