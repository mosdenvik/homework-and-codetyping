package AbstractClass_Interface_Practice;

public abstract class Pet {
	private String name;
	private float weight;
	private boolean voice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isVoice() {
		return voice;
	}
	public void setVoice(boolean voice) {
		this.voice = voice;
	}
	
	public Pet(String name, float weight, boolean voice) {
		this.name = name;
		this.weight = weight;
		this.voice = voice;
	}
	
	public void sleep(){
		System.out.println("It is sleeping");
	}
	public void eat(){
		System.out.println("It is eating");
	}
	public void run(){
		System.out.println("It is running");
	}
	
	public abstract void makeSound();
	
	
	
	
}
