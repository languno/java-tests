package tests;

/**
 * Bitwise and shift operations example.
 *
 * @author Tino Ernst
 */
public class ByteAritmetic {
	public static void main(String[] args) {
		byte a;
		
		a = 10;
		System.out.println(a + 3);
		a = 15;
		System.out.println(a - 3);
		a = 20;
		System.out.println(a * 3);
		a = 25;
		System.out.println(a / 3);
		a = 30;
		System.out.println(a % 3);
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
		printBinary(a << 3);
		
		a = 55;
		System.out.println("a = 55 >>");
		printBinary(a);
		System.out.println(a >> 3);
		printBinary(a);
		
		a = 60;
		System.out.println("a = 60 >>>");
		printBinary(a);
		System.out.println(a >>> 3);
		printBinary(a);
		
		a = -127;
		System.out.println("a = -127, >>> 3");
		printBinary(a);				// 11111111111111111111111110000001
		printBinary(a >>> 3);		// 00011111111111111111111111110000

		a = -127;
		System.out.println("a = -127, >> 3");
		printBinary(a);				// 11111111111111111111111110000001
		printBinary(a >> 3);		// 11111111111111111111111111110000

		a = 127;
		System.out.println("a = 127, >>> 3");
		printBinary(a);
		printBinary(a >>>= 3);
		
		a = 127;
		System.out.println("a = 127, >> 3");
		printBinary(a);
		printBinary(a >>= 3);

		int i = -1;

		System.out.println("i = -1");
		printBinary(-1);

		System.out.println("i  = -1 >>> 3");
		printBinary(i >>> 3);

		System.out.println("i  = -1 >> 3");
		printBinary(i >> 3);
	}

	private static void printBinary(int i) {
		System.out.println(String.format("%32s",
				Integer.toBinaryString(i)).replace(' ', '0'));
	}
}
