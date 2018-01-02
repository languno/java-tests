package tests;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String args[]) {

		// Windows only
//		Path path = Paths.get("C:\\home\\joe\\foo");

		// Solaris syntax
//		Path path = Paths.get("/home/joe/foo");

		Path path = Paths.get("", "file.txt").toAbsolutePath();

		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		System.out.format("URI: %s%n", path.toUri());
		
		Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");
		System.out.println("path with home: " + p5.toString());
		
		Path p6 = Paths.get("test", "log.txt");
		System.out.format("p6 relative: %s%n", p6.toString());
		System.out.format("p6 absolute: %s%n", p6.toAbsolutePath());
		
		System.out.println("##########");
		System.out.format("HOME: %s%n", System.getProperty("user.home"));
		System.out.format("Current (launched from): %s%n", System.getProperty("user.dir"));
		System.out.format("Current (from executable): %s%n", Paths.get("").toAbsolutePath());
	}
}
