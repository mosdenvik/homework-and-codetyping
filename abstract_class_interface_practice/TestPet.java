package abstract_class_interface_practice;

public class TestPet {

	public static void main(String[] args) {
		Pet dog = new Dog("Sharik", 40, 4, true);
		System.out.println(dog);
		dog.eat();
		dog.walk();
		dog.sleep();
		dog.makeSound();
		
		Parrot parrot = new Parrot("Kesha", (float) 0.1, true, 2, 2);
		System.out.println(parrot);
		parrot.fly();
		parrot.eat();
		parrot.walk();
		parrot.sleep();
		parrot.makeSound();
		
		Turtle turtle = new Turtle("Tortilla", 20, false, true);
		System.out.println(turtle);
		turtle.eat();
		turtle.walk();
		turtle.sleep();
		turtle.makeSound();
		turtle.moving((float) 1);
		turtle.swim();
		new Turtle("Matilda", 20, false, false, true).swim();
	}
}
