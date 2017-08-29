package polymorphism;

public class PolyMain {
	public static void main(String[] args) {
		
		Human humanAdult = new Adult();
		humanAdult.sayHello();
		
		Human humanSarah = new Sarah();
		humanSarah.sayHello();
		
		Adult adultSarah = new Sarah();
		adultSarah.sayHello();
		
		Sarah sarah = new Sarah();
		sarah.sayHello();
		
	}
}
