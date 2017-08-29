package testpackage;

import tests.PackagePrivateTest;

public class PackagePrivateConsumer {
	public static void main(String[] args) {
		PackagePrivateTest p = new PackagePrivateTest();
		
		// this works only in the same package
		//p.ppField = 3; // not visible
	}
}
