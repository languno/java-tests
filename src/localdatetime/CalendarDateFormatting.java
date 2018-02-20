package localdatetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Demonstrates the formatting of date and time information.
 *
 * @author Tino Ernst
 */
public class CalendarDateFormatting {
	public static void main(String[] args) {
		
		System.out.println("DATE");
		LocalDate ld = LocalDate.now();
		
		System.out.println("LocalDate now: " + ld);
		System.out.println("LocalDate ISO_WEEK_DATE: " + ld.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println("LocalDate SHORT LocalizedDate: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		System.out.println("LocalDate MEDIUM LocalizedDate: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("LocalDate LONG LocalizedDate: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		System.out.println("LocalDate FULL LocalizedDate: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		
		System.out.println("TIME");
		LocalTime lt = LocalTime.now();
		System.out.println("LocalTime now: " + lt);
		System.out.println("LocalTime SHORT LocalizedTime: " + lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		System.out.println("LocalTime MEDIUM LocalizedTime: " + lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		
		// reverse passing LocalTime to formatter
		System.out.println("LocalTime Formatter MEDIUM LocalizedTime: " + DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(lt));
		
		System.out.println("DATE/TIME");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("LocalDateTime now: " + ldt);
		System.out.println("LocalDateTime SHORT LocalizedDateTime: " + ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
		System.out.println("LocalDateTime MEDIUM LocalizedDateTime: " + ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		
		System.out.println("LocalDateTime SHORT LocalizedDate: " + ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		System.out.println("LocalDateTime SHORT LocalizedTime: " + ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		
		System.out.println();
		OffsetDateTime odt = OffsetDateTime.now();
		System.out.println("OffsetDateTime now: " + odt);
		System.out.println("OffsetDateTime ISO_DATE: " + odt.format(DateTimeFormatter.ISO_DATE));
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("ZonedDateTime now: " + zdt);
		System.out.println("ZonedDateTime RFC_1123_DATE_TIME: " + zdt.format(DateTimeFormatter.RFC_1123_DATE_TIME));
		
		System.out.println();
		System.out.println("Specialized formatters");
		System.out.println("LocalDateTime pattern: " + ldt.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		
	}
}
