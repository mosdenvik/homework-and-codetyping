package EnumPractice;


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
	
	private int day;
	
	Month(int day) {
		this.day = day;
	}
	
	int getDay() {
		return day;
	}

	Month nextMonth () {
		//System.out.println("Next month: ");
		Month nextMonth = values()[(ordinal() + 1) % values().length];
	    return nextMonth;
	}
	
		
	String setSeason(){
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
	
}

