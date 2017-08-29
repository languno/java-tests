package tests;

public class MethodParameterTest {

	public static void main(String[] args) {

		
		DataClass dc = new DataClass(3);
		
		System.out.println("x: " + dc.getX());
		
		// pass as reference
		changeData(dc);
		
		System.out.println("x: " + dc.getX());
	}
	
	public static void changeData(DataClass d) {
		d.setX(d.getX() + 1);
		
		d = new DataClass(0); // this has no effect
	}
}

class DataClass {
	int x;

	public DataClass(int x) {
		super();
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}

