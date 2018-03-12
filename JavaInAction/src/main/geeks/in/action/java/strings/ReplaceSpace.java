package geeks.in.action.java.strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 * 
 * @author manishdevraj
 * 
 */
public class ReplaceSpace {

	public String replaceSpaces(String stringValue) {
		if (stringValue != null)
			return replaceSpacesWith(stringValue.toCharArray(),
					stringValue.length());
		return null;
	}

	/**
	 * 1. Count the number of spaces during the first scan of the string. 2.
	 * Parse the string again from the end and for each character: »»If a space
	 * is encountered, store “%20”. »»Else, store the character as it is in the
	 * newly shifted location.
	 * 
	 * @param str
	 * @param length
	 */
	private String replaceSpacesWith(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] strArray = new char[newLength];
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				strArray[newLength - 1] = '0';
				strArray[newLength - 2] = '2';
				strArray[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				strArray[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return String.copyValueOf(strArray);
	}
}
