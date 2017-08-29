package tests;

public class StringReplaceAllRegex {
	public static void main(String[] args) {
		String[] inputs = { "aabfooaabfooabfoob", "aabfooaabfooabfooa" };
		String[] regexes = {
				"a?b", // a once or not at all, b
				"a+b", // a one or more times, b
				"a*b", // a zero or more times, b
				"^a*b", // begin of line
				"a*b$", // end of line
				"a+b?", // a once or more times, b once or not at all
		};
		String replacement = "-";
			
		for (String input : inputs) {
			for (String regex : regexes) {
				print(input, regex, replacement);
			}
			System.out.println();
		}
	}
	
	private static void print(String input, String regex, String replacement) {
		
		// replaceAll with regex string
		String output = input.replaceAll(regex, replacement);
		
		System.out.println("intput: " + input + " regex: " + regex + " replacement: "
				+ replacement + " output: " + output);
	}
}
