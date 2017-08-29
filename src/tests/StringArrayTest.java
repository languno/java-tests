package tests;

public class StringArrayTest {
	public static void main(String[] args) {
		String[] students = new String[10]; // allocates 10 references
		String studentName = "Peter";		// allocates one string object
		
		students[0] = studentName;
		studentName = null;
		
		System.out.println("students[0] length: " + students[0].length());
		System.out.println("students[1] length: " + students[1].length()); // nullpointer exception
		
	}
}
