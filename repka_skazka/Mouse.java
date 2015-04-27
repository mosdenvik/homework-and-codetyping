package repka_skazka;

public class Mouse extends Animal{

	public Mouse(String name, int powerOfTakingRepka) {
		super(name, powerOfTakingRepka);
		
	}

	@Override
	public Object callSomebodyToHelp(Object Animal) {
		return Animal;
	}

	
	@Override
	public String toString() {
		return "Animal [name: " + super.getName() + ", PowerOfTakingRepka: " +  super.getPowerOfTakingRepka() + "]";
	}
}
