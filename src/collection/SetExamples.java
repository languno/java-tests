package collection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.time.DayOfWeek;

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

		/* EnumSet:
		 *		easy iteration over enum values
		 *		all elements of the same enum
		 */
		 for (DayOfWeek d : EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.FRIDAY))
		        System.out.println("DayOfWeek: " + d);

		/* CopyOnWriteArraySet:
		 * 		backed up by a copy-on-write array
		 *  	all mutative operations, such as add, set, and remove, are implemented by making a new copy of the array
		 *  	no locking is ever required
		 *  	add, remove, and contains methods require time proportional to the size of the set
		 *  	this implementation is only appropriate for sets that are rarely modified but frequently iterated
		 */
		 Set<String> cowSet = new CopyOnWriteArraySet<>();
			fillSet(cowSet);
			System.out.println("CopyOnWriteArraySet: " + cowSet);
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
