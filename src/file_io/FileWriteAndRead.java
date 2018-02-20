package file_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Writing to and reading from files.
 *
 * @author Tino Ernst
 */
public class FileWriteAndRead {
	public static void main(String[] args) {

		String filename = "test.txt";

		Path filePath = Paths.get(filename);
		Charset charset = StandardCharsets.UTF_8;
		OpenOption openOption = Files.exists(filePath) ? APPEND : CREATE;

		System.out.println("filePath: " + filePath.toAbsolutePath().toString());

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath, charset, openOption))) {
			String dt = LocalDateTime.now().toString()
					.replaceAll("T", " @ ")
					.replaceAll("\\.\\d{0,3}$" , "");
			writer.println("Test line " + dt);
		} catch (IOException ioe) {
			System.out.println("Error on writing file: " + ioe);
		}

		try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
			String line;
			System.out.println("File content:");

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException ioe) {
			System.out.println("Error on reading file: " + ioe);
		}

		// delete file if it has more than 2 lines
		try {
			long lineCount = Files.lines(filePath).count();
			if (lineCount > 2) {
				Files.delete(filePath);
				System.out.println("Deleted file...");
			}
		} catch (IOException ioe) {
			System.out.println("Error on delete file: " + ioe);
		}
	}
}
