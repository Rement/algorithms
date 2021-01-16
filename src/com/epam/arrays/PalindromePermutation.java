package com.epam.arrays;


import java.util.Arrays;
import java.util.Locale;

// Palindrome permutation
public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isAnyPermutationPalindrome("Teact   Coa"));
        System.out.println(palindromePermutation.isAnyPermutationPalindrome("Tact   Coa"));
    }

    // O(N) solution
    private boolean isAnyPermutationPalindrome(String str) {
        final int unicodeCharCount = 65536;
        str = str.toLowerCase(Locale.ROOT);

        byte[] charList = new byte[unicodeCharCount];

        for (int i = 0; i < str.length(); i++) { // O(N)
            final byte c = (byte) str.charAt(i); // O(1)
            if (c != 32) {
                charList[c]++;
            }
        }

        boolean couldBeOdd = true;
        for (byte b : charList) { // O(65536 * 1) = O(1)
            if (b % 2 != 0) {
                if (couldBeOdd) {
                    couldBeOdd = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
