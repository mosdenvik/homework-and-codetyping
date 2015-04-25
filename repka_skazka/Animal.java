package repka_skazka;


public abstract class Animal {
	private String name;
	private int powerOfTakingRepka; // Human power of taking repka from groung in kg 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPowerOfTakingRepka() {
		return powerOfTakingRepka;
	}
	public void setPowerOfTakingRepka(int powerOfTakingRepka) {
		this.powerOfTakingRepka = powerOfTakingRepka;
	}
	
	
	public Animal(String name, int powerOfTakingRepka){
		this.name = name;
		this.powerOfTakingRepka = powerOfTakingRepka;
	}
	
	
		
	public boolean takeRepka(){
		if(AllObjectsOfSkazka.generalPowerOfAllObjects >= Repka.getWeightRepka()){
			return true;
		}
		return false;
	}
	
	
	
	public abstract Object callSomebodyToHelp(Object Animal);
	
}
