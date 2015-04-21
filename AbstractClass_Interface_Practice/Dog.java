package AbstractClass_Interface_Practice;

public class Dog extends Pet{
	private int paw; // ����
	
	public int getPaw() {
		return paw;
	}
	public void setPaw(int paw) {
		this.paw = paw;
	}
	
	public Dog(String name, float weight, int paw, boolean voice) {
		super(name, weight, voice);
		this.paw = paw;
	}
	
	@Override
	public void makeSound() {
		System.out.println("Gav-gav-gav!");
	}
	
	@Override
	public String toString() {
		return "Pet is " + Dog.class.getSimpleName() + " [name: " + super.getName() + ", weight: " + super.getWeight() + ", voice: " + super.isVoice()
				+ ", paw: " + getPaw() + "]";
	}
}