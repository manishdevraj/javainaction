package geeks.in.action.java.strings;

/**
 * We define an anagram to be a word whose characters can be rearranged to create another word. Given two strings,
 * we want to know the minimum number of characters already in either string that we must modify to make the two
 * strings anagrams; if it's not possible to make the two strings anagrams, we consider this number to be -1.
 * For example:
 •	tea and ate are anagrams, so we would need to modify a minimum of 0 characters.
 •	tea and toe are not anagrams, but we can modify a minimum of 1 character in either string to make them anagrams.
 •	act and acts are not anagrams and cannot be converted to anagrams because they contain different numbers of
 characters, so the minimum number of characters to modify is -1.
 Complete the function in the editor below. It has two parameters:
 1.	An array of n strings, a.
 2.	An array of n strings, b.
 The function must return an array of integers where each element i denotes the minimum number of characters you
 must modify to make ai and bi anagrams; if it's not possible to modify the existing characters in ai and bi to make
 them anagrams, element i should be -1 instead.
 Note: You can only modify existing characters in the strings, you cannot delete or append characters
 to change a string's length.

 * Created by manishdevraj on 20/03/18.
 */
public class TryAnagram {

    /**
     * Check if the two strings have identical counts for each unique char.
     * And if not see if we can replace equivalent chars in second string
     * @param s
     * @param t
     * @return
     */
    public int minToMakeAnagram(final String s, final String t) {
        if (s == null || t == null)
            return -1;
        if (s.length() != t.length())
            return -1;
        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        int num_diff_chars = 0;
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            if (letters[c] == 0)
                ++num_unique_chars;
            ++letters[c];
        }
        for (int i = 0; i < t.length(); ++i) {
            int c = t.charAt(i);
            if (letters[c] == 0) { // Found more of char c in t than in s.
                ++num_diff_chars;
            } else {
                --letters[c];
                if (letters[c] == 0) {
                    ++num_completed_t;
                    if (num_completed_t == num_unique_chars) {
                        // it’s a match if t has been processed completely
                        if (i == t.length() - 1) return 0;
                    }
                }
            }
        }

        if(num_unique_chars - num_completed_t == num_diff_chars) {
            return num_diff_chars;
        }

        return -1;
    }
}
