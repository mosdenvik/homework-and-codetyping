package repka_skazka;

public class Babka extends Human{

	public Babka(String name, int powerOfTakingRepka){
		super(name, powerOfTakingRepka);
	}
	
	
	@Override
	public Object callSomebodyToHelp(Object Human) {
		return Human;
	}
	
		
	@Override
	public String toString() {
		return "Human [name: " + super.getName() + ", PowerOfTakingRepka: " +  super.getPowerOfTakingRepka() + "]";
	}


	
	
}
