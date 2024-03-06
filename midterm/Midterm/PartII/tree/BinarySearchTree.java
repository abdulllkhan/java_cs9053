package tree;

public class BinarySearchTree {
    private TreeNode root;

    
    public BinarySearchTree() {
        root = null;
    }


    // Insert value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        if (value < root.value) {
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
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
    
    public static void main(String[] args) {
    	
    	TreeNode tn = new TreeNode(5);
    	if (tn instanceof Comparable<?>) {
    		Comparable<?> c = (Comparable<?>)tn;
    	}
    	/* this is how it works now: */
    	BinarySearchTree bst0 = new BinarySearchTree();
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
    	BinarySearchTree<Object> bst2 = new BinarySearchTree<>();
    	for (int i=0;i<10;i++) {
    		Object val = new Object();
    		bst2.insert(val);
    	}
    	bst2.inorder();
    	
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
    }
}