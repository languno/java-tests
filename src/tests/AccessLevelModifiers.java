package tests;

public class AccessLevelModifiers {
	public static void main(String[] args) {
		PackagePrivateTest p = new PackagePrivateTest();
		
		// this works only in the same package
		p.ppField = 3;
	}
}
