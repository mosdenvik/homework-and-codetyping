package repka_skazka;

public class Ded extends Human{
	
	public Ded(String name, int powerOfTakingRepka){
		super(name, powerOfTakingRepka);
	}

	public Repka growRepka(){
		return new Repka();
	}
	
	
	@Override
	public Object callSomebodyToHelp(Object Human) {
		return Human;
	}

		
	@Override
	public String toString() {
		return "Ded [Name: " + super.getName() + ", PowerOfTakingRepka: " + super.getPowerOfTakingRepka() + "]";
	}

	

	

	
	
	
	
}
