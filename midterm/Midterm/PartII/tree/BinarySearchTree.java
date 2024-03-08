package tree;

import java.util.Comparator;
import pair.Pair;

public class BinarySearchTree<T>{
	
    private TreeNode<T> root;
	private Comparator<T> comparator;
    
    public BinarySearchTree() {
        root = null;
		comparator = null;
    }

	public BinarySearchTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	// Compare two values. can be public? check again
	@SuppressWarnings("unchecked")
	private Integer compare(T a, T b) {
		if (comparator != null) {
			return comparator.compare(a, b);
		} else {
			return ((Comparable<T>)a).compareTo(b);
		}	
	}

    // Insert value into the BST
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> root, T value) {

        if (root == null) {
			root = new TreeNode<>(value);
            return root;
        }

		// Integer comparison = compare(value, root.value);
        if (compare(value, root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (compare(value, root.value) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Search for a value in the BST
    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (compare(value, root.value) == 0){
            return true;
        }

        if (compare(value, root.value) < 0) {
        	return searchRec(root.left, value);
        } else {
        	return searchRec(root.right, value);
        }
    }

    // Method to call inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " \n");
            inorderRec(root.right);
        }
    }
    
    public static void main(String[] args) {
    	
		TreeNode<Integer> tn = new TreeNode<>(5);
    	if (tn instanceof Comparable<?>) {
    		Comparable<?> c = (Comparable<?>)tn;
    	}
    	/* this is how it works now: */
    	BinarySearchTree<Integer> bst0 = new BinarySearchTree<>();
    	for (int i=0;i<10;i++) {
    		int val = (int)(Math.random()*100);
    		System.out.println("inserting " + val);
    		bst0.insert(val);
    	}
    	bst0.inorder();
    	
    	/* this is how it should be able to work :*/
    	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    	for (int i=0;i<10;i++) {
    		int val = (int)(Math.random()*100);
    		System.out.println("inserting " + val);
    		bst.insert(val);
    	}
    	bst.inorder();
    	
    	/* this will fail during the insert or constructor call
    	 * because Objects are not Comparable,
    	 * unless I pass in a Comparator into the constructor
    	 */
		// commenting because this code is only needed for testing

    	// BinarySearchTree<Object> bst2 = new BinarySearchTree<>();
    	// for (int i=0;i<10;i++) {
    	// 	Object val = new Object();
    	// 	bst2.insert(val);
    	// }
    	// bst2.inorder();
    	
    	/* Assume I have a BST named bst3 that takes Pair objects 
    	 * where the Pair objects have Key,Value pairs of 
    	 * Integer and String,  and the ordering I have chosen 
    	 * for the binary search tree is to be order by the keys 
    	 * in ascending order (that is to say, Integers). 
    	 * In this case, after creating the BST 
    	 * (code not included here), we this should work:
    	 * 
    	 * Pair<Integer, String> p1 = new Pair(5, "John");
    	 * bst3.insert(p1);
    	 * Pair<Integer, String> p2 = new Pair(3, "Bob");
    	 * bst3.insert(p2);
    	 * Pair<Integer, String> p3 = new Pair(9, "Alice");
    	 * bst3.insert(p3);
    	 * Pair<Integer, String> p4 = new Pair(13, "Mallory");
    	 * bst3.insert(p4);
    	 * Pair<Integer, String> p5 = new Pair(7, "Larry");
    	 * bst3.insert(p5);
    	 * 
    	 * And the output of:
    	 * bst3.inorder();
    	 * 
    	 * will be:
    	 * 
    	 * Pair[key=3, value=Bob] Pair[key=5, value=John] \
    	 *  Pair[key=7, value=Larry] Pair[key=9, value=Alice] \
    	 *  Pair[key=13, value=Mallory]
    	 * 
    	 */

		// new binary search tree with a comparator for ascending order of keys
		BinarySearchTree<Pair<Integer, String>> bst3 = new BinarySearchTree<>(Comparator.comparing(Pair<Integer, String>::getKey));

		// creating and adding pairs to the new created bst
		Pair<Integer, String> p1 = new Pair<>(5, "John");
		bst3.insert(p1);
		Pair<Integer, String> p2 = new Pair<>(3, "Bob");
		bst3.insert(p2);
		Pair<Integer, String> p3 = new Pair<>(9, "Alice");
		bst3.insert(p3);
		Pair<Integer, String> p4 = new Pair<>(13, "Mallory");
		bst3.insert(p4);
		Pair<Integer, String> p5 = new Pair<>(7, "Larry");
		bst3.insert(p5);
		System.out.println("\nBST Ordered by key in ascending order");
		bst3.inorder();

		// new binary search tree with a comparator for descending order of keys
		BinarySearchTree<Pair<Integer, String>> bst4 = new BinarySearchTree<>(Comparator.comparing(Pair<Integer, String>::getKey).reversed());

		// adding pairs to the new created bst
		bst4.insert(p1);
		bst4.insert(p2);
		bst4.insert(p3);
		bst4.insert(p4);
		bst4.insert(p5);
		System.out.println("\nBST Ordered by key in descending order");
		bst4.inorder();


		// new bst ordered by value
		BinarySearchTree<Pair<Integer, String>> bst5 = new BinarySearchTree<>(Comparator.comparing(Pair<Integer, String>::getValue));

		// adding pairs to the new created bst
		bst5.insert(p1);
		bst5.insert(p2);
		bst5.insert(p3);
		bst5.insert(p4);
		bst5.insert(p5);
		System.out.println("\nBST Ordered by value");
		bst5.inorder();






    }
}