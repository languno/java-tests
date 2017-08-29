package exceptionexample;

public class DriedOutException extends Exception {
	private static final long serialVersionUID = 1358625534088692302L;

	public DriedOutException() {
		super();
	}
	
	public DriedOutException(String s) {
		super(s);
	}
}
