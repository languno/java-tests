package exceptionexample;

public class Tester {
	public static void main(String[] args) {
		new Tester();
	}
	
	public Tester() {
		Bonsai b = new Bonsai();
	
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Next week");
				b.nextWeek();
			}
		} catch (DriedOutException doe) {
			doe.printStackTrace();
		}
	}
}
