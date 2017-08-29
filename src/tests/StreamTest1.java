package tests;

import java.util.List;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;

class StreamTest1 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(Arrays.asList("one", "two"));
		Stream<String> sl = l.stream();
		l.add("three");
		String s = sl.collect(Collectors.joining(" "));
		System.out.println(s);
	}
}
