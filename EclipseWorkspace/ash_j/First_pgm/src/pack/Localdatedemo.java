package pack;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
/*import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
*/

public class Localdatedemo {
public static void main(String[] args) {
	
	/*DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/mm/yyyy");
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("enter date in dd/mm/yyyy format ");
	String input =scanner.nextLine();
	LocalDate enteredDate=LocalDate.parse(input,formatter);
	System.out.println(enteredDate);
	scanner.close(); */
	
	
	/*DateTimeFormatter formatter1= DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
	DateTimeFormatter formatter2= DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	DateTimeFormatter formatter3= DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	DateTimeFormatter formatter4= DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	
	LocalDate currentdate=LocalDate.now();
	
	
	System.out.println(currentdate.format(formatter1));
	System.out.println(currentdate.format(formatter2));
	System.out.println(currentdate.format(formatter3));
	System.out.println(currentdate.format(formatter4));*/
	
	/*LocalDate currentdate=LocalDate.now();
	System.out.println(currentdate);
	LocalDate independencedate=LocalDate.of(1947, Month.AUGUST, 15);
	
	System.out.println(currentdate.plusDays(1));
	System.out.println(currentdate.minusMonths(1));
	System.out.println(currentdate.isLeapYear());
	System.out.println(currentdate.lengthOfMonth());
	System.out.println(currentdate.withDayOfMonth(1));
	
	ZonedDateTime currentTime=ZonedDateTime.now();
	ZonedDateTime currentTimeInParis=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
	System.out.println(independencedate);
	System.out.println(currentTime);
	System.out.println(currentTimeInParis);
	
	*/
	LocalDate independenceDate=LocalDate.of(1947, Month.AUGUST, 15);
	LocalDate currentdate=LocalDate.now();
	Period diff=independenceDate.until(currentdate);
	System.out.println("Years : "+diff.getYears());
	System.out.println("Months : "+diff.getMonths());
	System.out.println("Days : "+diff.getDays());
	//DateTimeFormatter formatter5= DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
	//System.out.println(diff.format(formatter5));
	
}
}
