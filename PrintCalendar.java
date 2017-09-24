public class PrintCalendar {
	
	public static void main(String[] args){
		Calendar cal1 = new Calendar();
		cal1.printMonth();
		Calendar cal2 = new Calendar(2017,1);
		cal2.printMonth();
		cal2.setYear(2016);
		cal2.setMonth(10);
		cal2.printMonth();
	}
}