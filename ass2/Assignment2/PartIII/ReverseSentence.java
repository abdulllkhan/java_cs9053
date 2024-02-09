
public class ReverseSentence {

	public static String reverseSentence(String sentence) {

		sentence = sentence.substring(0, 1).toLowerCase() + sentence.substring(1);
		String[] words = sentence.split(" ");

		String reversed = "";
		for(int i = words.length - 1; i > -1; i--){	
			reversed += words[i] + " ";
		}

		reversed = reversed.substring(0, 1).toUpperCase() + reversed.substring(1);

		return reversed.substring(0, reversed.length() - 1);
	}
	
	public static void main(String[] args) {

		String result = reverseSentence("The quick brown fox jumps over the lazy dog");

		System.out.println("The resversed sentence is: \"" + result + "\"");

	}

}
