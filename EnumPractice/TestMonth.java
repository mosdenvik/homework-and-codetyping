package EnumPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestMonth {
	
	public static void main(String[] args) throws IOException {
		Month aMonth = Month.JUNE;
		
		for (Month m: Month.values()) // print all from Enum
			System.out.println(m);
		
			
		System.out.println("---------------------");
			for (int i = 0; i < Month.values().length; i++) {  // print month according to season 
				aMonth = aMonth.nextMonth();
				System.out.println(aMonth + " is " + aMonth.setSeason());
			}
			
		System.out.println("---------------------");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int month;
		Month[] monthArray = Month.values();
		System.out.println("Inpun month number:");  // print month according to index
		while (true) {
			month = Integer.parseInt(reader.readLine());
			if(month == 0 || month > monthArray.length){
				System.out.println("Wrong month index!");
				break;
			}else if(month == 1){
				System.out.println("Month is January. It has " + aMonth.JANUARY.getDay() + " days");
			}else if(month == 2){
				System.out.println("Month is February. It has " + aMonth.FEBRUARY.getDay() + " days");
			}else if(month == 3){
				System.out.println("Month is March. It has " + aMonth.MARCH.getDay() + " days");
			}else if(month == 4){
				System.out.println("Month is April. It has " + aMonth.APRIL.getDay() + " days");
			}else if(month == 5){
				System.out.println("Month is May. It has " + aMonth.MAY.getDay() + " days");
			}else if(month == 6){
				System.out.println("Month is June. It has " + aMonth.JUNE.getDay() + " days");
			}else if(month == 7){
				System.out.println("Month is July. It has " + aMonth.JULY.getDay() + " days");
			}else if(month == 8){
				System.out.println("Month is August. It has " + aMonth.AUGUST.getDay() + " days");
			}else if(month == 9){
				System.out.println("Month is September. It has " + aMonth.SEPTEMBER.getDay() + " days");
			}else if(month == 10){
				System.out.println("Month is October. It has " + aMonth.OCTOBER.getDay() + " days");
			}else if(month == 11){
				System.out.println("Month is November. It has " + aMonth.NOVEMBER.getDay() + " days");
			}else if(month == 12){
				System.out.println("Month is December. It has " + aMonth.DECEMBER.getDay() + " days");
			}else{
				break;
				
			}
		}
	}
}

