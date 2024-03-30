package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<Character> stack = new MyStack<Character>();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// boolean result = isBalanced("(()()()())");
		System.out.print("The string \"(()()()())\" is: " );
		if(isBalanced("(()()()())")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
		
		// result = isBalanced("(((())))");
		System.out.print("The string \"(((())))\" is: " );
		if(isBalanced("(((())))")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}

		// result = isBalanced("((((((())");
		System.out.print("The string \"((((((())\" is: " );
		if(isBalanced("((((((())")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}

		System.out.print("The string \"(()()))\" is: " );
		if(isBalanced("(()()))")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}
}
