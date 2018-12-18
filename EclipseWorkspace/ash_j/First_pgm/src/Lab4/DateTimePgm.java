package Lab4;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimePgm {
	public static void main(String[] args) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/mm/yyyy");
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter date in dd/mm/yyyy format ");
		String input =scanner.nextLine();
		LocalDate enteredDate=LocalDate.parse(input,formatter);
		System.out.println(enteredDate);
		
		ZonedDateTime currentTime=ZonedDateTime.now();
		ZonedDateTime currentTimeInParis=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(currentTime);
		System.out.println(currentTimeInParis);
	
}
}