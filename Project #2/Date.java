public class Date {
	private int year;
	private int month;
	private int day;

	//this is the constructor
	public Date (int month, int day , int year){

		this.month = month;
		if (month == 1|| month ==3||month==5||month==8||month==10||month==12){

			if (day> 0 && day<=31)
				this.day = day;
		}
		else if (month==4||month==6||month==9||month==11){
			if (day>0 && day<=30)
				this.day = day;
		}
		else
			if (day>0 && day <=28)
				this.day = day;
		if (year>= 1900 && year <=3000)
			this.year = year;

	}
	//accessor
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}
	public int getYear(){
		return year;
	}
	public int dayOfYear(){

		int totalDays = 0;
		switch (month){
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}

		totalDays+=day;

		return totalDays;

	}

	// comparing 
	public int compare (Date dt){

		int sum = Math.abs(((this.dayOfYear() - dt.dayOfYear())+ 365*(this.getYear()-dt.getYear()))/30);

		if (sum>60)
			return 60;
		else 
			return sum;

	}
}