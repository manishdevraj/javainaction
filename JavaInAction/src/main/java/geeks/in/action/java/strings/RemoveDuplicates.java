package geeks.in.action.java.strings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not. FOLLOW UP Write the
 * test cases for this method.
 * 
 * @author manishdevraj
 * 
 */
public class RemoveDuplicates {

	/**
	 * Algorithm—No (Large) Additional Memory: 1. For each character, check if
	 * it is a duplicate of already found characters. 2. Skip duplicate
	 * characters and update the non duplicate characters. Time complexity is
	 * O(N2).
	 * 
	 * @param str
	 */
	public String removeDuplicatesx(char[] str) {
		if (str == null)
			return null;
		int len = str.length;
		if (len < 2)
			return new String(str);

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}

		return new String(str);
	}

	public String removeDuplicates(char[] str) {
		if (str == null)
			return null;
		int len = str.length;
		if (len < 2)
			return new String(str);
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}

		return new String(str);
	}
}
