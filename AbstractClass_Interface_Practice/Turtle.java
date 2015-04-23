package AbstractClass_Interface_Practice;

public class Turtle extends Pet implements Moveable{
	
	private String turtleShell; // �������
	private int paw; // ����
	
	public String getTurtleShell() {
		return turtleShell;
	}
	public void setTurtleShell(String turtleShell) {
		this.turtleShell = turtleShell;
	}
	
	public int getPaw() {
		return paw;
	}
	public void setPaw(int paw) {
		this.paw = paw;
	}
	
	public Turtle(String name, int weight, boolean voice, String turtleShell, int paw) {
		super(name, weight, voice);
		this.turtleShell = turtleShell;		
		this.paw = paw;
	}

	
	
	@Override
	public void makeSound() {
		System.out.println("Turtle is silent animal. No any sound!");
	}

	@Override
	public void turtleMove(float speed) {
		if(speed == 0){
			System.out.println("Turtle does not move.");
		}else if(speed > 0 && speed <= 1.0){
			System.out.println("Turtle is moving.");
		}else{
			System.out.println("Turtle is super fast Turtle!");
		}
	}
	
	@Override
	public String toString() {
		return "Pet is " + Turtle.class.getSimpleName() + " [name: " + super.getName() + ", weight: " + super.getWeight() + ", voice: " + super.isVoice()
				+ ", shell: " + getTurtleShell() + ", paw: " + getPaw() + "]";
	}
}