package interfacedescribable;

public class GoatFood implements Describable {
	private String food;
	
	public GoatFood(String food) {
		this.food = food;
	}

	@Override
	public String getDescription() {
		return "Goatfood of " + this.food;
	}
}
