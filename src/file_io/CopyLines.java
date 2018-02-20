package file_io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Demonstrates formated reading and writing of text lines in traditional file api.
 *
 * Source: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 *
 * @author Tino Ernst
 */
public class CopyLines {
	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("input.txt"));
			outputStream = new PrintWriter(new FileWriter("output.txt"));

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
