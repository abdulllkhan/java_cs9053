import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

	public static char charFrequency(String s) {

		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
		int n = s.length();

		for(int i = 0; i < n; i++){
			char character = s.charAt(i);
			if(charCount.containsKey(character)){
				charCount.put(character, charCount.get(character) + 1);
			} else {
				charCount.put(character, 1);
				charIndex.put(character, i);
			}
		}

		int maxCount = 0;
		for(Integer value: charCount.values()){
			if(value > maxCount){
				maxCount = value;
			}
		}

		int minIndex = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> mapEntry :charCount.entrySet()){
			if(mapEntry.getValue() == maxCount){
				Integer tempIndex = charIndex.get(mapEntry.getKey());
				if(minIndex > tempIndex){
					minIndex = tempIndex;
				}
			}
		}
		
		return s.charAt(minIndex);
	}
	
	public static String randomStringGenerator(int chars) {
		char[] charArray = new char[chars];
		for (int i=0;i<charArray.length;i++) {
			char c = (char)((int)(Math.random()*26) + 'a');
			charArray[i] = c;
		}
		return new String(charArray);
	}
	
	public static void main(String[] args) {
		// String s = "ppabcdeapapqarr";
		String s = randomStringGenerator(10);
		// String s = randomStringGenerator(100);
		char result = charFrequency(s);
		System.out.println("Most frequently occuring character in the string \"" + s + "\" is: " + result);
	}
}
