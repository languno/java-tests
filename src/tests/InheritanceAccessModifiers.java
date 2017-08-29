package tests;

public class InheritanceAccessModifiers {
	public static void main(String[] args) {
		
		class Base {
			//public String test() throws Exception {
			public String test() {
				return "base";
			}
		}
		
		class Subclass extends Base {
			// compiliert nicht, da access modifier eingeschränkt wird
			//protected String test() { 
			public String test() throws RuntimeException { // nur subclasses der exceptions
				return "sub";
			}
		}
		
		Base base = new Base();
		Subclass sub = new Subclass();
		Base subBase = new Subclass();
		
		System.out.println("base: " + base.test());
		System.out.println("sub: " + sub.test());
		System.out.println("subbase: " + subBase.test());
	}
}
