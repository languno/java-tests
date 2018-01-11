package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Examples of Map interface implementations.
 * 
 * @author Tino Ernst
 */
public class MapExamples {
	public static void main(String[] args) {
		
		/* HashMap:
		 * 		permits null as key or value
		 * 		unsynchronized
		 * 		unsorted
		 * 		O(n) constant-time performance for get, contains, put
		 */
		Map<String, String> hashMap = new HashMap<>();
		fillMap(hashMap);
		System.out.println("HashMap: " + hashMap);
		
		/* TreeMap:
		 * 		does not use hash, it uses a Red-Black tree
		 * 		sorted in natural order of the keys
		 * 		O(log(n)) for containsKey, get, put, remove
		 * 		implements SortedMap and NavigableMap
		 */
		Map<String, String> treeMap = new TreeMap<>();
		fillMap(treeMap);
		System.out.println("TreeMap: " + treeMap);
		
		/*
		 * LinkedHashMap:
		 * 		extends HashMap
		 * 		with an doubly-linked list for predictable iteration order (ordered keys)
		 * 		faster than TreeMap
		 * 		O(n) constant time for put, contains, remove because inherited form HashMap 
		 */
		// preserves same order than the hashMap instance
		Map<String, String> linkedHashMapPreservedOrder = new LinkedHashMap<>(hashMap);
		System.out.println("LinkedHashMap with preserved order of hashMap: " + linkedHashMapPreservedOrder);
		
		Map<String, String> linkedHashMap = new TreeMap<>();
		fillMap(linkedHashMap);
		System.out.println("LinkedHashMap: " + linkedHashMap);
	}
	
	private static void fillMap(Map<String, String> map) {
		map.put("2", "two");
		map.put("1", "one");
		map.put("1", "one more"); // overwrites "one"
		map.put("d", "d");
		map.put("dd", "dd");
	}
}
