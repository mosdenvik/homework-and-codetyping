package repka_skazka;

import java.util.logging.Level;
import java.util.logging.Logger;


public class RepkaApp {
	private static final Logger logger = Logger.getLogger(RepkaApp.class.getName());

	public static void main(String[] args) {
		logger.log(Level.INFO, "currently in main()");
		System.out.println("---------------------");
		
		Human ded = new Ded("Ded", 30);
		AllObjectsOfSkazka.addObject(ded);
		System.out.println(ded);
		System.out.println("������� ��� �����:");
		System.out.println(((Ded) ded).growRepka());
		System.out.println("������� ����� ������, ������, �������-����������:");
		
		Repka repka = new Repka("Repka", "White", 100);
		System.out.println(repka);
		System.out.println("����� ��� ����� �����:");
		System.out.println(ded.takeRepka());
		System.out.println("������ ��� �����:");
		
		Human babka = new Babka("Babka", 20);
		AllObjectsOfSkazka.addObject(babka);
		System.out.println(ded.callSomebodyToHelp(babka));
		System.out.println("�����-�������, �������� �� �����...");
		System.out.println(babka.takeRepka());
		
		Human vnuchka = new Vnuchka("Vnuchka", 15);
		AllObjectsOfSkazka.addObject(vnuchka);
		System.out.println(babka.callSomebodyToHelp(vnuchka));
		System.out.println("�����-�������, �������� �� �����...");
		System.out.println(vnuchka.takeRepka());
		
		Animal zhuchka = new Dog("Zhuchka", 15);
		AllObjectsOfSkazka.addObject(zhuchka);
		System.out.println(vnuchka.callSomebodyToHelp(zhuchka));
		System.out.println("�����-�������, �������� �� �����...");
		System.out.println(zhuchka.takeRepka());
		
		Animal koshka = new Cat("Koshka", 12);
		AllObjectsOfSkazka.addObject(koshka);
		System.out.println(zhuchka.callSomebodyToHelp(koshka));
		System.out.println("�����-�������, �������� �� �����...");
		System.out.println(koshka.takeRepka());
		
		Animal myshka = new Mouse("Myshka", 8);
		AllObjectsOfSkazka.addObject(myshka);
		System.out.println(koshka.callSomebodyToHelp(myshka));
		System.out.println("�����-������� - � �������� �����!");
		System.out.println(myshka.takeRepka());
		
			
	}

}
