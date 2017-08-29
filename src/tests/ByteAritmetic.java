package tests;

public class ByteAritmetic {
	public static void main(String[] args) {
		byte a;
		
		a = 10;
		System.out.println(a += 3);
		a = 15;
		System.out.println(a -= 3);
		a = 20;
		System.out.println(a *= 3);
		a = 25;
		System.out.println(a /= 3);
		a = 30;
		System.out.println(a %= 3);
		a = 35;
		System.out.println("a = 35");
		printBinary(a);
		System.out.println(a &= 3);
		printBinary(a);
		
		a = 40;
		System.out.println("a = 40 ^");
		printBinary(a);
		System.out.println(a ^= 3);
		printBinary(a);
		
		a = 45;
		System.out.println("a = 45 |");
		printBinary(a);
	 	System.out.println(a |= 3);
	 	printBinary(a);
	 	
		a = 50;
		System.out.println("a = 50 <<");
		printBinary(a);
		System.out.println(a <<= 3);
		printBinary(a);
		
		a = 55;
		System.out.println("a = 55 >>");
		printBinary(a);
		System.out.println(a >>= 3);
		printBinary(a);
		
		a = 60;
		System.out.println("a = 60 >>>");
		printBinary(a);
		System.out.println(a >>>= 3);
		printBinary(a);
		
		a = -127;
		System.out.println("a = -127, >>> 3");
		printBinary(a);
		System.out.println(a >>>= 3);
		printBinary(a);
		
		a = -127;
		System.out.println("a = -127, >> 3");
		printBinary(a);
		System.out.println(a >>= 3);
		printBinary(a);
		
		a = 127;
		System.out.println("a = 127, >>> 3");
		printBinary(a);
		printBinary(a >>>= 3);
		
		a = 127;
		System.out.println("a = 127, >> 3");
		printBinary(a);
		printBinary(a >>= 3);
		
	}
	
	private static void printBinary(byte b) {		
		System.out.println(String.format("%8s",
	            Integer.toBinaryString((b + 256) % 256)).replace(' ', '0'));
	}
}
