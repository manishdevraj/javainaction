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
        int[] letters = new int[256];
        int first_unique_chars = 0;
        int sec_unique_chars = 0;
        int num_completed = 0;
        char[] f_array = first.toCharArray();
        for (char c : f_array) { // count number of each char in first string.
            if (letters[c] == 0)
                ++first_unique_chars; //mark all of them unique
            ++letters[c];
        }
        for (int i = 0; i < second.length(); ++i) {
            int c = second.charAt(i);
            if (letters[c] == 0) { // Found more of char c in second than in first.
                ++sec_unique_chars;
            } else {
                --letters[c];
                if (letters[c] == 0) {
                    ++num_completed;
                }
            }
        }

        return (first_unique_chars - num_completed) + sec_unique_chars;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        String a = "imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln";//in.next();
        String b = "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy";//in.next();
        System.out.println(numberNeeded(a, b));
    }
}


