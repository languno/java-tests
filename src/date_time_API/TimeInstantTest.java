package date_time_API;

import java.time.*;

/**
 * Some examples of the date/time and period/duration classes.
 *
 * @author Tino Ernst
 */
public class TimeInstantTest {
	public static void main(String[] args) {
		Instant instantNow = Instant.now();
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		ZoneId defZone = ZoneId.systemDefault();
		
		ZonedDateTime zonedDateTimeNow = ZonedDateTime.of(localDateTimeNow, defZone);
		
		//OffsetDateTime offsetDateTime = OffsetDateTime.of(instantNow, ZoneOffset.of(defZone));
		
		
		System.out.println("Instant.now(): " + instantNow);
		System.out.println("LocalDateTime.now():" + localDateTimeNow);
		
		System.out.println("LocalDateTime.ofInstant: "
				+ LocalDateTime.ofInstant(instantNow, ZoneId.systemDefault()));
		
		//System.out.println("OffsetDateTime of instant: " + offsetDateTime);
		
		System.out.println("ZonedDateTime of LocalDateTime: " + zonedDateTimeNow);
		
		
		System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));
		
		Period p = Period.of(0, 13, 0);
		System.out.println("Period: " + p + " normalized: " + p.normalized());
		
		Duration d = Duration.ofDays(100);
		System.out.println("Duration: " + d);
	}
}
