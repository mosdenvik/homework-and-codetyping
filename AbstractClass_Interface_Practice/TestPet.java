package AbstractClass_Interface_Practice;

public class TestPet {

	public static void main(String[] args) {
		Pet dog = new Dog("Sharik", 40, 4, true);
		System.out.println(dog);
		dog.eat();
		dog.run();
		dog.sleep();
		dog.makeSound();
		
		Parrot parrot = new Parrot("Kesha", (float) 0.1, true, 2, 2);
		System.out.println(parrot);
		parrot.fly(2);
		parrot.eat();
		parrot.run();
		parrot.sleep();
		parrot.makeSound();
		
		Turtle turtle = new Turtle("Tortilla", 20, false, "Turtle-Shell", 4);
		System.out.println(turtle);
		turtle.eat();
		turtle.run();
		turtle.sleep();
		turtle.makeSound();
		turtle.turtleMove((float) 0.5);
	}
}
