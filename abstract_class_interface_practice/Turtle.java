package abstract_class_interface_practice;

public class Turtle extends Pet implements Moveable, Swimable{
	
	private boolean paws; // lapy
	private boolean fins; // plavniki
	
	public boolean isPaws() {
		return paws;
	}
	public void setPaws(boolean paws) {
		this.paws = paws;
	}
	public boolean isFins() {
		return fins;
	}
	public void setFins(boolean fins) {
		this.fins = fins;
	}

	public Turtle(String name, int weight, boolean voice, boolean paws) {
		super(name, weight, voice);
		this.paws = paws;
	}
	
	public Turtle(String name, int weight, boolean voice, boolean paws, boolean fins) {
		super(name, weight, voice);
		this.paws = paws;
		this.fins = fins;
	}
		
	@Override
	public void makeSound() {
		System.out.println("Turtle is silent animal. No any sound!");
	}

	@Override
	public void moving(float speedMetrPerMinutes) {
		if(paws == true){
			if(speedMetrPerMinutes == 0){
				System.out.println("Turtle does not move.");
			}else if(speedMetrPerMinutes > 0 && speedMetrPerMinutes < 1.0){
				System.out.println("Turtle is moving.");
			}else{
				System.out.println("Turtle is super fast Turtle!");
			}
		}else{
			System.out.println("Turtle ");;
		}
	}
	
	@Override
	public void swim() {
		if(fins == true){
			System.out.println("Turtle can swim!");
		}else{
			System.out.println("Turtle can't swip. It is tortoise."); // suhoputnaya
		}
	}
	
	@Override
	public String toString() {
		return "Pet is " + Turtle.class.getSimpleName() + " [name: " + super.getName() + ", weight: " + super.getWeight() + ", voice: " + super.isVoice()
				+  ", paws: " + isPaws() +  ", fins: " + isFins() + "]";
	}
	
}
