package com.epam.arrays;

// Simple string compression using the count of repeated chars
public class StringCompression {

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.stringCompression("aaabbaaaccae"));
    }

    // O(N) solution
    private String stringCompression(String str) {
        final char[] chars = str.toCharArray();
        if (str.isEmpty()) { // O(1)
            return null;
        }
        char currentChar = chars[0];
        int currentCharCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) { // O(N)
            if (chars[i] == currentChar) { // O(1)
                currentCharCount++;
            } else {
                stringBuilder
                        .append(currentChar) // O(1)
                        .append(currentCharCount); // O(1)
                currentChar = chars[i];
                currentCharCount = 1;
            }

            if (i == chars.length - 1) {
                stringBuilder
                        .append(currentChar) // O(1)
                        .append(currentCharCount); // O(1)
            }
        }

        return stringBuilder.toString();
    }
}
