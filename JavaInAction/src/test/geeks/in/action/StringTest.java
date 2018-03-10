package geeks.in.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geeks.in.action.strings.Anagram;
import geeks.in.action.strings.RemoveDuplicates;
import geeks.in.action.strings.UniqueChars;

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
}
