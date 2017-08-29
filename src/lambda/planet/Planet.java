package lambda.planet;

import javafx.scene.paint.Color;

public class Planet {
	private String name = "Unknown";
	private Color primaryColor = Color.WHITE;
	private Integer numberOfMoons = 0;
	private Boolean ringed = false;

	public Planet(String name, Color primaryColor, Integer numberOfMoons,
			Boolean ringed) {
		this.name = name;
		this.primaryColor = primaryColor;
		this.numberOfMoons = numberOfMoons;
		this.ringed = ringed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(Color primaryColor) {
		this.primaryColor = primaryColor;
	}

	public Integer getNumberOfMoons() {
		return numberOfMoons;
	}

	public void setNumberOfMoons(Integer numberOfMoons) {
		this.numberOfMoons = numberOfMoons;
	}

	public Boolean isRinged() {
		return ringed;
	}

	public void setRinged(Boolean ringed) {
		this.ringed = ringed;
	}
	
	public String toString() {
		return this.name;
	}
}
