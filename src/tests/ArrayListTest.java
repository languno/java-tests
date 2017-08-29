package tests;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Integer i1 = new Integer(1000);
		Integer i2 = 2000;
		int i3 = 3000;
		Integer i4 = new Integer(4000);
		
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		
		System.out.println(list);
		
		list.add(1, 1500);
		
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list[" + i + "] = "
					+ list.get(i));
		}
		
		list.remove(1);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-----------");
		
		
	}
}
