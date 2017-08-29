package tests;

public class FindbugsStringTest {
	public static void main(String[] args) {
		String s1 = new String("String one"); // inefficient  use
		String s2 = "String two";
		String s3 = "String " + "two";
	}
}
