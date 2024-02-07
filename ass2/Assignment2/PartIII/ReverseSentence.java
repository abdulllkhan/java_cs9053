
public class ReverseSentence {

	public static String reverseSentence(String sentence) {

		String[] words = sentence.split(" ");
		String reversed = "";
		for(int i = words.length - 1; i > -1; i--){	
			reversed += words[i] + " ";
		}

		return reversed.substring(0, reversed.length() - 1);
	}
	
	public static void main(String[] args) {

		String result = reverseSentence("The quick brown fox jumps over the lazy dog");

		System.out.println("The resversed sentence is: \"" + result + "\"");

	}

}
