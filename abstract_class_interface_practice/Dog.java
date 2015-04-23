package abstract_class_interface_practice;

public class Dog extends Pet{
	private int paws; // lapy
	
	public int getPaws() {
		return paws;
	}
	public void setPaws(int paws) {
		this.paws = paws;
	}
	
	public Dog(String name, float weight, int paws, boolean voice) {
		super(name, weight, voice);
		this.paws = paws;
	}
	
	@Override
	public void makeSound() {
		System.out.println("Gav-gav-gav!");
	}
	
	@Override
	public String toString() {
		return "Pet is " + Dog.class.getSimpleName() + " [name: " + super.getName() + ", weight: " + super.getWeight() + ", voice: " + super.isVoice()
				+ ", paws: " + getPaws() + "]";
	}
}