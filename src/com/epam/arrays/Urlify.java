package com.epam.arrays;

// Replace all spaces with %20
public class Urlify {

    public static void main(String[] args) {
        Urlify urlify = new Urlify();
        System.out.println(urlify.urlify("Mr John  Smith      ", 14));
    }

    // O(N) solution
    private String urlify(String str, int actualSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < actualSize; i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
    }


}
