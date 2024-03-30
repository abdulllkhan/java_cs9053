package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue<E> implements Queue<E> {
	
	private ArrayList<E> ar;

	public MyQueue() {
		ar = new ArrayList<E>();
	}
	
	public boolean add(E e) {
		return ar.add(e);
	}

	public boolean offer(E e) {
		return ar.add(e);
	}

	public E remove() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.remove(0);
	}

	public E poll() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.remove(0);
	}

	public E element() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.get(0);
	}

	public E peek() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.get(0);
	}

	public boolean addAll(Collection<? extends E> c) {
		return ar.addAll(c);
	}

	public void clear() {
		ar.clear();
	}

	public boolean contains(Object o) {
		return ar.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return ar.containsAll(c);
	}

	public boolean isEmpty() {
		return ar.isEmpty();
	}

	public Iterator<E> iterator() {
		return ar.iterator();
	}

	public boolean remove(Object o) {
		return ar.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return ar.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return ar.retainAll(c);
	}

	public int size() {
		return ar.size();
	}

	public Object[] toArray() {
		return ar.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return ar.toArray(a);
	}

}
