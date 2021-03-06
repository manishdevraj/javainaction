package geeks.in.action.java.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

 Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

 Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 * Created by manishdevraj on 03/04/18.
 */
public class MakingAnagram {

    public static int numberNeeded(String first, String second) {
        int[] letters = new int[26];
        char[] firstCharArray = first.toCharArray();
        char[] secCharArray = second.toCharArray();
        for (int i = 0; i < first.length(); i++)
            letters[firstCharArray[i] - 'a']++;

        for (int i = 0; i < second.length(); i++)
            letters[secCharArray[i] - 'a']--;

        int result = 0;
        for(int i = 0; i < letters.length; i++)
            result += Math.abs(letters[i]);
        return result;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        String a = "imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln";//in.next();
        String b = "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy";//in.next();
        System.out.println(numberNeeded(a, b));
    }
}


