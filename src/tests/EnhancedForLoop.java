package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnhancedForLoop {
	public static void main(String[] args) throws IOException {
		float fishLengthList[] = { 10.0f, 15.5f, 18.0f, 29.5f, 45.5f };
		float requiredLength = 28f;
		
		
		boolean wrongNumber = true;
		do {
			//try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("Required length: ");
				requiredLength = Float.parseFloat(br.readLine());
				wrongNumber = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number!");
			}
		} while (wrongNumber);
		
		for (float length: fishLengthList) {
			if (length > requiredLength) {
				System.out.println("Length: " + length);
			}
		}
	}
}
