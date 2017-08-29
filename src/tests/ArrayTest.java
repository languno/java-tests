package tests;

import java.util.Arrays;
import java.awt.Color;

public class ArrayTest {

	public static void main(String[] args) {
		int[] intArr = new int[4];
		printArray(intArr);
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = i + 1;
		}
		
		printArray(intArr);
		
		String[][] strArr = new String[2][3];
		for (String[] sarr : strArr) {
			printArray(sarr);
		}
		
		printArray(new Integer(3), new Integer(4));
		
		System.out.println("newIntArr after copy");
		int[] newIntArr = Arrays.copyOf(intArr, 6);
		printArray(newIntArr);
		
		System.out.println("intArr");
		printArray(intArr);
		
		Object[] strangeObjs = { new Integer[1], new Integer[2] };
		System.out.println("strange objs");
		printArray(strangeObjs);
		
		strangeObjs[1] = new Integer(3);
		
		System.out.println("-----------");
		
		Color[] colorArr = new Color[4];
		colorArr[0] = Color.BLUE;
		colorArr[1] = Color.BLUE.brighter();
		
		printArray(colorArr);
	}
	
	private static void printArray(int[] arr) {
		System.out.println("int array " + Arrays.toString(arr));
	}
	
	private static <T> void printArray(T... arr) {
		System.out.println("T array " + Arrays.toString(arr));
	}

}
