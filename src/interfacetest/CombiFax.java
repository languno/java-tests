package interfacetest;

import java.io.File;

public class CombiFax implements Phone, Fax {

	@Override
	public void sendFile(File f) {
		System.out.println("CombiFax sendFile");		
	}

	@Override
	public boolean dial(int number) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int lastDialed() {
		return 0;
	}

	public static void main(String[] args) {
		CombiFax fax = new CombiFax();
		
		Phone p = fax;
		fax.sendFile(null);
		p.sendFile(null);
		
		Fax f = (Fax)fax;
		f.sendFile(null);
		
		int x= 0;
		
		do {
			x = x + 2;
			System.out.println(x);
		} while (--x < 5);
	}
}
