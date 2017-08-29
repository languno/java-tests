package lambda.water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WaterApp {
	public static void main(String[] args) {
		Water hardWater = new Water("Hard");
		Water softWater = new Water("Soft");
		Water boiledWater = new Water("Boiled");
		Water rainWater = new Water("Rain");
		
		List<Water> waterList = new ArrayList<>();
		waterList.add(hardWater);
		waterList.add(softWater);
		waterList.add(boiledWater);
		waterList.add(rainWater);
		
		// without sort
		System.out.println("Not sorted: " + waterList);
		
		// sort as own comparator class
//		WaterSort waterSort = new WaterSort();
//		Collections.sort(waterList, waterSort);
		
		// sort as anonymous inner class
//		Comparator<Water> waterSort = new Comparator<Water>() {
//			@Override
//			public int compare(Water w1, Water w2) {
//				return w1.getSource().compareTo(w2.getSource());
//			}
//		};
//		Collections.sort(waterList, waterSort);
		
		// sort as lambda expression
//		Comparator<Water> waterSort = (Water w1, Water w2) -> w1.getSource().compareTo(w2.getSource());
//		Collections.sort(waterList, waterSort);
		
		// sort as lambda skip inline the comparator interface
		//Collections.sort(waterList, (Water w1, Water w2) -> w1.getSource().compareTo(w2.getSource()));
		
		// sort list with Comparator.comparing that uses the Function FI to extract the attribute to be compared
		waterList.sort(Comparator.comparing(w -> w.getSource()));
		
		System.out.println("Sorted: " + waterList);
	}
}
