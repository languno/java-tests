package tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuizCollectionTest {
	public static final void main(String[] mydata) {
		Collection<String> coll = new ArrayList<>();
		coll.add("uno");
		coll.add("dos");
		coll.add("tres");
		System.out.println(coll);
		coll.remove(0);
		System.out.println(coll);
		
		List<String> col = new ArrayList<>();
		col.add("me");
		col.add("too");
		System.out.println(col);
		col.remove(0);
		System.out.println(col);
	}
}
