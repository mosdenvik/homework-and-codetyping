package enum_practice;

import java.io.IOException;


public class TestMonth {
	
	public static void main(String[] args) throws IOException{
		Month aMonth = Month.JANUARY;
		
		for (Month m: Month.values()){ // print all from Enum
			System.out.println(m);
		}
			
		System.out.println("---------------------");
			for (int i = 0; i < Month.values().length; i++) {  // print month according to season 
				aMonth = aMonth.nextMonth();
				System.out.println(aMonth + " is " + aMonth.monthSeason());
			}
			
		System.out.println("---------------------");
		aMonth.monthAccordingToIndex();
	}
}

