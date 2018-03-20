package geeks.in.action.java.strings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a
 * rotation of “erbottlewat”).
 * 
 * @author manishdevraj
 * 
 */
public class StringInRotation {

	/**
	 * Just do the following checks 1. Check if length(s1) == length(s2). If
	 * not, return false. 2. Else, concatenate s1 with itself and see whether s2
	 * is substring of the result. input: s1 = apple, s2 = pleap ==> apple is a
	 * substring of pleappleap input: s1 = apple, s2 = ppale ==> apple is not a
	 * substring of ppaleppale
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return s1s1.indexOf(s2) != -1;
		}
		return false;
	}
}
