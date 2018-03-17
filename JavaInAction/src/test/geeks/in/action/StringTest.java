package geeks.in.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import geeks.in.action.java.strings.Anagram;
import geeks.in.action.java.strings.FirstReapatedWord;
import geeks.in.action.java.strings.RemoveDuplicates;
import geeks.in.action.java.strings.ReplaceSpace;
import geeks.in.action.java.strings.StringInRotation;
import geeks.in.action.java.strings.UniqueChars;

import org.junit.Test;

public class StringTest extends BaseTestCase {

	@Test
	public void testUniqueChars() {
		UniqueChars uniqueChars = new UniqueChars();

		assertTrue(uniqueChars.isUniqueChars("abdc"));
		assertFalse(uniqueChars.isUniqueChars("javainaction"));
		assertTrue(uniqueChars.isUniqueChars("manish"));

		assertTrue(uniqueChars.isUniqueCharsUsingBitwise("abdc"));
		assertFalse(uniqueChars.isUniqueCharsUsingBitwise("javainaction"));
		assertTrue(uniqueChars.isUniqueCharsUsingBitwise("manish"));
	}

	@Test
	public void testRemoveDuplicates() {
		RemoveDuplicates obj = new RemoveDuplicates();

		assertEquals("abcd", obj.removeDuplicates("abcd".toCharArray()));
		assertEquals("a", obj.removeDuplicates("aaaa".toCharArray()));
		assertEquals(null, obj.removeDuplicates(null));
		assertEquals("", obj.removeDuplicates("".toCharArray()));
		assertEquals("ab", obj.removeDuplicates("aaabbb".toCharArray()));
		assertEquals("ab", obj.removeDuplicates("abababa".toCharArray()));
	}

	@Test
	public void testAnagram() {
		Anagram obj = new Anagram();

		assertFalse(obj.anagram("abdc", "bda"));
		assertTrue(obj.anagram("manish", "anishm"));
		assertTrue(obj.anagram("apple", "ppale"));
		assertFalse(obj.anagram("a", "aaaaa"));
		assertTrue(obj.anagram("aaa", "aaa"));
		assertFalse(obj.anagram("", "aaaaa"));
		assertFalse(obj.anagram("a", null));
	}

	@Test
	public void testStringReplace() {
		ReplaceSpace obj = new ReplaceSpace();

		assertEquals("ab%20cd", obj.replaceSpaces("ab cd"));
		assertEquals("manish", obj.replaceSpaces("manish"));
		assertEquals("%20I%20am%20here%20to%20check%20few%20things%20",
				obj.replaceSpaces(" I am here to check few things "));
		assertNull(obj.replaceSpaces(null));
	}

	@Test
	public void testStringInRotation() {
		StringInRotation obj = new StringInRotation();

		assertTrue(obj.isRotation("waterbottle", "erbottlewat"));
		assertTrue(obj.isRotation("apple", "pleap"));
		assertFalse(obj.isRotation("apple", "ppale"));
	}

	@Test
	public void testFindFirstDupllicateWordInString() {
		FirstReapatedWord obj = new FirstReapatedWord();

		assertEquals(
				"had",
				obj.findFirstReoccuring("Manish had been saying that he had been there"));
		assertEquals("he", obj.findFirstReoccuring("he had had he"));
		assertNull(obj.findFirstReoccuring(" I am here to check few things "));
		assertNull(obj.findFirstReoccuring("I have been saying that"));
	}
}
