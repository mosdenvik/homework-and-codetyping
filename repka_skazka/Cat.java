package repka_skazka;

public class Cat extends Animal{

	public Cat(String name, int powerOfTakingRepka) {
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

