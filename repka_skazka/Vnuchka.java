package repka_skazka;

public class Vnuchka extends Human{
	
	public Vnuchka(String name, int powerOfTakingRepka){
		super(name, powerOfTakingRepka);
	}

	@Override
	public Object callSomebodyToHelp(Object Animal) {
		return Animal;
	}

		
	@Override
	public String toString() {
		return "Human [name: " + super.getName() + ", PowerOfTakingRepka: " +  super.getPowerOfTakingRepka() + "]";
	}

	
}
