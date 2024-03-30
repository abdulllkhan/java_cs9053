package PartII;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {

		HashMap<E, Integer> map = new HashMap<E, Integer>();
		MathSet<E> result = new MathSet<E>();
		for (E element : this) {
			map.put(element, 1);
		}
		for (E element : s2) {
			if (map.containsKey(element)) {
				result.add(element);
			}
		}
		map.clear();
		return result;
		
	}
	
	public Set<E> union(Set<E> s2) {

		HashMap<E, Integer> map = new HashMap<E, Integer>();
		MathSet<E> result = new MathSet<E>();
		for (E element : this) {
			map.put(element, 1);
		}
		for (E element : s2) {
			if(!map.containsKey(element)) {
				map.put(element, 1);
			}
		}
		for (E element : map.keySet()) {
			result.add(element);
		}
		map.clear();
		return result;

	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		
		MathSet<Pair<E,T>> result = new MathSet<Pair<E,T>>();
		for (E element1 : this) {
			for (T element2 : s2) {
				result.add(new Pair<E,T>(element1, element2));
			}
		}
		return result;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.

		MathSet<Integer> set1 = new MathSet<>();
		MathSet<Integer> set2 = new MathSet<>();
		// Add elements to set1 and set2
		set1.add(11);
		set1.add(12);
		set1.add(13);
		set1.add(14);
		set1.add(15);

		set2.add(13);
		set2.add(14);
		set2.add(15);
		set2.add(16);
		set2.add(17);

		// Perform union and intersection operations
		Set<Integer> unionResult = set1.union(set2);
		Set<Integer> intersectionResult = set1.intersection(set2);

		// Print the results
		System.out.println("\nUnion: " + unionResult);
		System.out.println("\nIntersection: " + intersectionResult);

		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<String> set3 = new MathSet<>();
		set3.add("A");
		set3.add("B");
		set3.add("D");
		set3.add("U");
		set3.add("L");

		// Cartesian Product
		Set<Pair<Integer, String>> cartesianProductResult = set1.cartesianProduct(set3);
		System.out.println("\nCartesian Product: " + cartesianProductResult);
		System.out.println("\nSize of Cartesian Product: " + cartesianProductResult.size());
	}
}
