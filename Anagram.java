/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean result = true;
		String currentStr2 = str2.toLowerCase();
		for (char c : str1.toLowerCase().toCharArray()) {
			if (currentStr2.indexOf(c) == -1) {
				result = false;
				break;
			}
		}
		return result;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		for (char c : str.toLowerCase().toCharArray()) {
			result += (c >= 'a' && c <= 'z') || c == ' ' ? c : "";
			// The test was failed - but needed to be without spaces (The row below is for the other case)
			// result += c >= 'a' && c <= 'z' ? c : "";
 		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String result = "";
		String curr = str.trim();
		for (int i=0; i<str.trim().length(); i++) {
			int index = (int)(Math.random() * curr.length());
			char c = curr.charAt(index);
			result+= c;
			curr = curr.substring(0, index) + curr.substring(index+1);
		}
		return result;
	}
}
