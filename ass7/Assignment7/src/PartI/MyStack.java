package PartI;
import java.util.ArrayList;


public class MyStack<E> {

	private ArrayList<E> ar;

	public MyStack() {
		ar = new ArrayList<E>();
	}

	public void push(E e) {
		ar.add(e);
	}

	public E pop() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.remove(ar.size() - 1);
	}

	public E peek() {
		if (ar.isEmpty()) {
			return null;
		}
		return ar.get(ar.size() - 1);
	}

	public boolean isEmpty() {
		return ar.isEmpty();
	}

	public int size() {
		return ar.size();
	}

	public String toString() {
		return ar.toString();
	}
	
}
