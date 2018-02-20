package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Examples of Set interface implementations.
 * 
 * @author Tino Ernst
 */
public class SetExamples {
	public static void main(String[] args) {
		
		// General-Purpose Set Implementations
		
		/* HashSet:
		 * 		fast constant time performance O(n) for add, remove, contains, size
		 * 		no ordering guarantees
		 * 		permits null element
		 * 		not synchronized
		 */
		Set<String> hashSet = new HashSet<>();
		fillSet(hashSet);
		System.out.println("HashSet: " + hashSet);
		
		/* TreeSet:
		 * 		slower time performance O(log n) for add, remove, contains
		 * 		natural ordered iteration
		 * 		not synchronized
		 */
		Set<String> treeSet = new TreeSet<>();
		fillSet(treeSet);
		System.out.println("TreeSet: " + treeSet);
		
		/* LinkedHashSet:
		 * 		hash table with a doubly linked list for iteration
		 * 		insertion-oriented iteration
		 * 		when used copy constructor, the ordering if the input set remains 
		 */
		Set<String> linkedHashSet = new LinkedHashSet<>();
		fillSet(linkedHashSet);
		System.out.println("LinkedHashSet: " + linkedHashSet);
		
		// Special-Purpose Set Implementations
	}
	
	private static void fillSet(Set<String> set) {
		set.add("two");
		set.add("1");
		set.add("one");
		set.add("one"); // the set will not contain double elements
		set.add("2");
		set.add("d");
		set.add("dd");
	}
}
