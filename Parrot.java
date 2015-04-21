package AbstractClass_Interface_Practice;

public class Parrot extends Pet implements Flyable{

	private int wing; // крылья
	private int paw; // лапы
	
	
	public int getWing() {
		return wing;
	}
	public void setWing(int wing) {
		this.wing = wing;
	}
	public int getPaw() {
		return paw;
	}
	public void setPaw(int paw) {
		this.paw = paw;
	}

	public Parrot(String name, float weight, boolean voice, int paw, int wing) {
		super(name, weight, voice);
		this.paw = paw;
		this.wing = wing;
	}

	@Override
	public void fly(int wings) {
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
				+ ", paw : " + getPaw() + ", wing: " + getWing() + "]";
	}
}
