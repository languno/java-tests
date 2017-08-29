package exceptionexample;

public class Bonsai {
	private static final int DRY_OUT_WEEKS = 2;
	private int weeksWithoutWater = 0;
	
	public void nextWeek() throws DriedOutException {
		weeksWithoutWater++;
		if (weeksWithoutWater >= DRY_OUT_WEEKS) {
			throw new DriedOutException(String.valueOf(DRY_OUT_WEEKS) + " weeks without water");
		}
	}
}
