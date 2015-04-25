package repka_skazka;


public class TestRepka {

	public static void main(String[] args) {
		
		
		Human ded = new Ded("Ded", 30);
		AllObjectsOfSkazka.addObject(ded);
		System.out.println(ded);
		System.out.println("Посадил дед репку:");
		System.out.println(((Ded) ded).growRepka());
		System.out.println("Выросла репка сладка, крепка, большая-пребольшая:");
		
		Repka repka = new Repka("Repka", "White", 100);
		System.out.println(repka);
		System.out.println("Пошел дед репку рвать:");
		System.out.println(ded.takeRepka());
		System.out.println("Позвал дед бабку:");
		
		Human babka = new Babka("Babka", 20);
		AllObjectsOfSkazka.addObject(babka);
		System.out.println(ded.callSomebodyToHelp(babka));
		System.out.println("Тянут-потянут, вытянуть не могут...");
		System.out.println(babka.takeRepka());
		
		Human vnuchka = new Vnuchka("Vnuchka", 15);
		AllObjectsOfSkazka.addObject(vnuchka);
		System.out.println(babka.callSomebodyToHelp(vnuchka));
		System.out.println("Тянут-потянут, вытянуть не могут...");
		System.out.println(vnuchka.takeRepka());
		
		Animal zhuchka = new Dog("Zhuchka", 15);
		AllObjectsOfSkazka.addObject(zhuchka);
		System.out.println(vnuchka.callSomebodyToHelp(zhuchka));
		System.out.println("Тянут-потянут, вытянуть не могут...");
		System.out.println(zhuchka.takeRepka());
		
		Animal koshka = new Cat("Koshka", 12);
		AllObjectsOfSkazka.addObject(koshka);
		System.out.println(zhuchka.callSomebodyToHelp(koshka));
		System.out.println("Тянут-потянут, вытянуть не могут...");
		System.out.println(koshka.takeRepka());
		
		Animal myshka = new Mouse("Myshka", 8);
		AllObjectsOfSkazka.addObject(myshka);
		System.out.println(koshka.callSomebodyToHelp(myshka));
		System.out.println("Тянут-потянут - и вытянули репку!");
		System.out.println(myshka.takeRepka());
		
		
	}

}
