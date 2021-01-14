package com.epam.arrays;

import java.util.HashMap;
import java.util.Map;

// To check, if one string is a permutation of another
public class IsPermutation {

    public static void main(String[] args) {
        IsPermutation isPermutation = new IsPermutation();
        System.out.println(isPermutation.isPermutation("epavm", "epaam"));
        System.out.println(isPermutation.isPermutation("epam", "pame"));
    }

    // O(N) solution
    private boolean isPermutation(String a, String b) {
        final char[] firstStringCharArray = a.toCharArray();
        final char[] secondStringCharArray = b.toCharArray();

        if (firstStringCharArray.length != secondStringCharArray.length) { // O(1)
            return false;
        }
        Map<Character, Integer> firstCharacterIntegerMap = new HashMap<>();
        Map<Character, Integer> secondCharacterIntegerMap = new HashMap<>();
        populateMap(firstCharacterIntegerMap, firstStringCharArray); // O(N)
        populateMap(secondCharacterIntegerMap, secondStringCharArray); // O(N)

        return firstCharacterIntegerMap.equals(secondCharacterIntegerMap); // O(N)
    }

    private void populateMap(Map<Character, Integer> map,  char[] array) { // O(N) * O(1) = O(N)
        for (char c : array) { // O(N)
            map.merge(c, 1, Integer::sum); // O(1) for lookup and insert
        }
    }
}
