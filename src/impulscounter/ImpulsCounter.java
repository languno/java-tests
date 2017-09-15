package impulscounter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ImpulsCounter {

	// first sample was 63 = 2.96V
	// 42 = 1,97V
	static final int HEIGH_TRESHOLD = 42; //128;//42;
	static final double VOLT_MULTIPLIER = 12D / 255;
	static final double MILISEC_MULTIPLIER = 1D / 20;

	public static void main(String[] args) {
		
		int falingEdge = 0;
		int risingEdge = 0;
		int min = 255;
		int max = 0;
		int total = 0;
		int currLowCount = 0;
		int currHeighCount = 0;
		int smalestHeigh = Integer.MAX_VALUE;
		int smalestLow = Integer.MAX_VALUE;
		int smalestHeighTime = 0;
		int smalestLowTime = 0;
		boolean currentHeigh = true;
		List<Integer> smallLowTimes = new ArrayList<Integer>();
		List<Integer> smallHighTimes = new ArrayList<Integer>();
		
		 
		
		String filename = "bin\\impulscounter\\data.raw";
		
		
		
		try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filename))) {
			int content;
			while ((content = reader.read()) != -1) {
				
				total++;
				if (content > max)
					max = content;
				if (content < min)
					min = content;

				
				if (currentHeigh) {
					if (content < HEIGH_TRESHOLD) {
						// falling edge
						
						if (currHeighCount < smalestHeigh) {
							smalestHeigh = currHeighCount;
							smalestHeighTime = total;
						}
						
						if (currHeighCount < 18) {
							smallHighTimes.add(total);
						}
						
						currLowCount = 0;
						falingEdge++;
						currentHeigh = false;
					} else {
						currHeighCount++;
					}
				} else {
					if (content >= HEIGH_TRESHOLD) {
						// rising edge
						if (currLowCount < smalestLow) {
							smalestLow = currLowCount;
							smalestLowTime = total;
						}
						
						if (currLowCount < 18) {
							smallLowTimes.add(total);
						}
						
						currHeighCount = 0;
						risingEdge++;
						currentHeigh = true;
					} else {
						currLowCount++;
					}
				}
			}

			System.out.println("Datenpunkte gesamt:\t\t"+ total);
			System.out.println("Datenpunkt min. Wert:\t\t"+ min + " (" + (min*VOLT_MULTIPLIER) + " V)");
			System.out.println("Datenpunkt max. Wert:\t\t"+ max + " (" + (max*VOLT_MULTIPLIER) + " V)");
			System.out.println("Schwelle high/low:\t\t"+ HEIGH_TRESHOLD + " (" + (HEIGH_TRESHOLD*VOLT_MULTIPLIER) + " V)");
			System.out.println("Anzahl steigender Flanken:\t" + risingEdge);
			System.out.println("Anzahl fallender Flanken:\t" + falingEdge);
			System.out.println("Kürzeste High-Impulsbreite:\t" + smalestHeigh + " (" + (smalestHeigh*MILISEC_MULTIPLIER) + " ms)");
			System.out.println("Kürzeste Low-Impulsbreite:\t" + smalestLow + " (" + (smalestLow*MILISEC_MULTIPLIER) + " ms)");
			System.out.println("Kürzester High-Impuls Ende:\t" + smalestHeighTime + " (" + (smalestHeighTime*MILISEC_MULTIPLIER) + " ms)" + " " + Duration.ofMillis((long)(smalestLowTime*MILISEC_MULTIPLIER)).toString());
			System.out.println("Kürzester Low-Impuls Ende:\t" + smalestLowTime + " (" + (smalestLowTime*MILISEC_MULTIPLIER) + " ms)" + " " + Duration.ofMillis((long)(smalestLowTime*MILISEC_MULTIPLIER)).toString());
			
			System.out.println("Zu kurze High-Impulse (" + smallHighTimes.size() + "):");
			smallHighTimes.stream().forEach(i -> System.out.println("\t" + Duration.ofMillis((long)(i*MILISEC_MULTIPLIER)).toString()));
			
			System.out.println("Zu kurze Low-Impulse (" + smallLowTimes.size() + "):");
			smallLowTimes.stream().forEach(i -> System.out.println("\t" + Duration.ofMillis((long)(i*MILISEC_MULTIPLIER)).toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
