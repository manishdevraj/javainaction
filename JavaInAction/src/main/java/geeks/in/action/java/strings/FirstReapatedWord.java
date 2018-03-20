package geeks.in.action.java.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find the first repeated word in a string Given a string, Find the 1st
 * repeated word in a string
 * 
 * @author manishdevraj
 * 
 */
public class FirstReapatedWord {

	public String findFirstReoccuring(final String s) {
		if (s == null || s.isEmpty())
			return null;
		String[] tokens = s.split("\\W+");
		List<String> tokenList = Arrays.asList(tokens);
		for (String str : tokens) {
			if (Collections.frequency(tokenList, str) > 1) {
				return str;
			}
		}
		return null;
	}

}
