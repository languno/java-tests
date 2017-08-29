package tests;

public class EnumTest {
	enum ShipType {
		FRIGATTE, BATTLESHIP
	}
	static ShipType shipType = ShipType.BATTLESHIP;
	
	public static void main(String[] args) {
		System.out.println("ship is an " + shipType.name());
		System.out.println("toString " + shipType.toString());
	}
}
