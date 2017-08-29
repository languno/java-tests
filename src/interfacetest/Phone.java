package interfacetest;

import java.io.File;

public interface Phone {
	boolean dial(int number);
	default int lastDialed() {
		return 0;
	}
	default void sendFile(File f) {
		System.out.println("Phone sendFile");
	}
}
