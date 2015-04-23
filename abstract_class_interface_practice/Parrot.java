package abstract_class_interface_practice;

public class Parrot extends Pet implements Flyable{

	private int wings; // kril'ya
	private int paws; // lapy
	
	
	public int getWings() {
		return wings;
	}
	public void setWings(int wings) {
		this.wings = wings;
	}
	public int getPaws() {
		return paws;
	}
	public void setPaws(int paws) {
		this.paws = paws;
	}

	public Parrot(String name, float weight, boolean voice, int paws, int wings) {
		super(name, weight, voice);
		this.paws = paws;
		this.wings = wings;
	}

	@Override
	public void fly() {
		if(wings == 2){
			System.out.println("Parrot can fly!");
		}else{
			System.out.println("Invalid parrot :( It must have 2 wings!");
		}
	}

	@Override
	public void makeSound() {
		System.out.println("Chirik-chik-chik!");
	}
	
	@Override
	public String toString() {
		return "Pet is " + Parrot.class.getSimpleName() + " [name: " + super.getName() + ", weight: " + super.getWeight() + ", voice: " + super.isVoice()
				+ ", paws : " + getPaws() + ", wings: " + getWings() + "]";
	}
}
