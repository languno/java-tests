package tests;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterWithCharset {
	public static void main(String args[]) {
		Charset charset = Charset.forName("UTF-8");
		//Charset charset = Charset.forName("US-ASCII");
		String s = "This is a testäüöß";
		Path file = Paths.get("text.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(s, 0, s.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
}
