package interfacetest;

import java.io.File;

public interface Fax {
	default void sendFile(File f) {
		System.out.println("Fax sendFile");
	}
}
