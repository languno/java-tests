package lambda.planet;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class PlanetApp {
	public static void main(String[] args) {
		Planet mercury = new Planet("Mercury", Color.GREY, 0, false);
		Planet earth = new Planet("Earth", Color.BLUE, 1, false);
		Planet jupiter = new Planet("Jupiter", Color.YELLOW, 67, true);
		Planet uranus = new Planet("Uranus", Color.TEAL, 27, true);
		Planet neptune = new Planet("Neptune", Color.BLUE, 14, true);
		
		List<Planet> planetList = new ArrayList<>();
		planetList.add(mercury);
		planetList.add(earth);
		planetList.add(jupiter);
		planetList.add(uranus);
		planetList.add(neptune);
		
		System.out.println("Has one or more rings: "
							+ PlanetPredicates.filterPlanets(planetList, p -> p.isRinged()));
		
		System.out.print("Has moons and is blue: ");
		planetList.stream()
			.filter(p -> p.getNumberOfMoons() > 0 && p.getPrimaryColor() == Color.BLUE)
			.forEach(p -> System.out.print(p + " "));
		System.out.println();
		
		System.out.println("Has more then 20 moons: " +
				PlanetPredicates.listFilteredPlanets(planetList, PlanetPredicates.hasMoonsMoreThan(20)));
		
		System.out.print("Has a color not black: "); 
		planetList.stream()
			.filter(PlanetPredicates.hasAColor())
			.forEach(p -> System.out.print(p + " "));
	}
}
