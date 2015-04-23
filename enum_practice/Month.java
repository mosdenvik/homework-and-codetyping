package enum_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public enum Month {
	JANUARY (31),
	FEBRUARY (28),
	MARCH (31),
	APRIL (30),
	MAY (31),
	JUNE (30),
	JULY (31),
	AUGUST (31),
	SEPTEMBER (30),
	OCTOBER (31),
	NOVEMBER (30),
	DECEMBER (31);
	
	private int daysInMonth;
	
	Month(int daysInMonth) {
		this.daysInMonth = daysInMonth;
	}
	
	int getDaysInMonth() {
		return daysInMonth;
	}

	Month nextMonth () {
		//System.out.println("Next month: ");
		Month nextMonth = values()[(ordinal() + 1) % values().length];
	    return nextMonth;
	}
	
		
	String monthSeason(){
		switch (this){
		case DECEMBER:
		case JANUARY:
		case FEBRUARY:
			return "winter";
		case MARCH:
		case APRIL:
		case MAY:
			return "spring";
		case JUNE:
		case JULY:
		case AUGUST:
			return "summer";
		case SEPTEMBER:
		case OCTOBER:
		case NOVEMBER:
			return "autumn";
		
		default: return "error season";
		}
	}
	
	public void monthAccordingToIndex() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int month;
		Month[] monthArray = Month.values();
		System.out.println("Inpun month number:"); 
		while (true) {
			month = Integer.parseInt(reader.readLine());
			if(month == 0 || month > monthArray.length){
				System.out.println("Wrong month index!");
				break;
			}else if(month == 1){
				System.out.println("Month is January. It has " + Month.JANUARY.getDaysInMonth() + " days");
			}else if(month == 2){
				System.out.println("Month is February. It has " + Month.FEBRUARY.getDaysInMonth() + " days");
			}else if(month == 3){
				System.out.println("Month is March. It has " + Month.MARCH.getDaysInMonth() + " days");
			}else if(month == 4){
				System.out.println("Month is April. It has " + Month.APRIL.getDaysInMonth() + " days");
			}else if(month == 5){
				System.out.println("Month is May. It has " + Month.MAY.getDaysInMonth() + " days");
			}else if(month == 6){
				System.out.println("Month is June. It has " + Month.JUNE.getDaysInMonth() + " days");
			}else if(month == 7){
				System.out.println("Month is July. It has " + Month.JULY.getDaysInMonth() + " days");
			}else if(month == 8){
				System.out.println("Month is August. It has " + Month.AUGUST.getDaysInMonth() + " days");
			}else if(month == 9){
				System.out.println("Month is September. It has " + Month.SEPTEMBER.getDaysInMonth() + " days");
			}else if(month == 10){
				System.out.println("Month is October. It has " + Month.OCTOBER.getDaysInMonth() + " days");
			}else if(month == 11){
				System.out.println("Month is November. It has " + Month.NOVEMBER.getDaysInMonth() + " days");
			}else if(month == 12){
				System.out.println("Month is December. It has " + Month.DECEMBER.getDaysInMonth() + " days");
			}
		}
	}
}

