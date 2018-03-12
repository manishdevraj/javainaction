package geeks.in.action.strings;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author manishdevraj
 * 
 */
public class Anagram {
	/**
	 * Check if the two strings have identical counts for each unique char.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean anagram(final String s, final String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}
}
