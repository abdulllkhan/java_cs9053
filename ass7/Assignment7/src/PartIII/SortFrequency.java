package PartIII;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortFrequency {

	public static void sortByFrequency(ArrayList<Integer> ar) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.size(); i++) {
			if (map.containsKey(ar.get(i))) {
				map.put(ar.get(i), map.get(ar.get(i)) + 1);
			} else {
				map.put(ar.get(i), 1);
			}
		}

		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); // sorting by frequency
		int index = 0;
		for (Entry<Integer, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++) {
				ar.set(index, entry.getKey());
				index++;
			}
		}

		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i=0;i<100;i++) {
			ar.add((int)(Math.random()*10));			
		}
		System.out.println("\nRandomly generated unsorted array:");
		System.out.println(ar.toString());
		sortByFrequency(ar);
		System.out.println("\nArray sorted by frequency:");
		System.out.println(ar.toString());
	}
}
