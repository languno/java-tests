package tests;

import java.util.Scanner;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("Test");
		StringBuilder sb2 = sb1.append(1234); // sb1 returns this reference
		
		System.out.println((sb1 == sb2) ? "same ref" : "different ref");
		System.out.println("sb1 is " + sb1);
		System.out.println("sb2 is " + sb2);
		
		StringBuilder a;
		a = new StringBuilder();
		//a = "Alicia"; // error
		a.append("Alicia Tino Cayetano Pillar Andreas Tania");
		a.reverse();
		System.out.println(a);
		
		String love = "Te quiero Alicia";
		System.out.println(new StringBuilder(love).reverse());
		
		Scanner sc = new Scanner (a.toString());
		
		while (sc.hasNext()) {
			String n = sc.next();
			System.out.println(n);
		}
		
		sc.close();
	}
}
