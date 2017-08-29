package localdatetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println("LocalDate now: " + ld);
		
		LocalDate tomorrow2020 = ld.plusDays(1).withYear(2020);
		System.out.println("LocalDate tomorrow2020: " + tomorrow2020);
		
		LocalTime lt = LocalTime.now();
		System.out.println("LocalTime now: " + lt);
		
		System.out.println("LocalTime now formatted: " + lt.format(DateTimeFormatter.ofPattern("HH:mm")));
		
		LocalTime noon = LocalTime.NOON;
		System.out.println("LocalTime NOON: " + noon);
	}
}
