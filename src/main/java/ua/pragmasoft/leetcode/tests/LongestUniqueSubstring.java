package ua.pragmasoft.leetcode.tests;

/**
 * 
 * Finds the longest substring of unique characters
 * 
 */
public class LongestUniqueSubstring {
	
	/**
	 * @param s String to find a longest substring of unique characters
	 * @return first longest substring of unique characters of the passed parameter s
	 */
	public static String longestUniqueSubstring(String s) {
		for (int i = 1; i < s.length(); i++) {
			final char c = s.charAt(i);
			final String prefix = s.substring(0, i);
			final int indexOfTheSameCharBefore = prefix.indexOf(c);
			if ( indexOfTheSameCharBefore >= 0) {
				final String suffix = s.substring(indexOfTheSameCharBefore + 1);
				final String longestUniqueSubstringOfSuffix = longestUniqueSubstring(suffix);
				return longestUniqueSubstringOfSuffix.length() > i ? longestUniqueSubstringOfSuffix : prefix;
			} 
		}
		return s;
	}
	
	

	public static void printResultOf(String s) {
		String result = longestUniqueSubstring(s);
		System.out.println("The longest unique substring of '" + s + "' is '" + result + "' (" + result.length() + ')');
	}
	
	public static void main(String[] args) {
		printResultOf("Hello World!");
		printResultOf("bbbbbbb");
		printResultOf("aqweqbw");
	}
}
