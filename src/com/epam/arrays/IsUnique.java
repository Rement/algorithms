package com.epam.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

// Determine, if a string contains only unique symbols
public class IsUnique {

    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique("AaZz"));
        System.out.println(isUnique.isUnique("AaaZz"));
        System.out.println(isUnique.isUnique("QWERTYUIOPASDFGHJKLZXCVBNM"));
        System.out.println(isUnique.isUnique("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm"));
    }

    // O(N) solution
    private boolean isUnique(String str) {
        final byte AByte = 65;
        final byte ZByte = 90;
        final byte aByte = 97;
        final byte zByte = 122;
        final byte[] strByteArray = str.getBytes(); // should be O(n)
        final byte[] resultArray = new byte[26 * 2]; // I assume, that big and small letters are different // O(1)

        for (byte byteChar : strByteArray) { // O(n)
            int tempIndex = 0;
            if (byteChar >= AByte && byteChar <= ZByte) { // big letters // O(1)
                tempIndex = byteChar - 65;
            } else if (byteChar >= aByte && byteChar <= zByte) { // small letters // O(1)
                tempIndex = byteChar - 97 + 26;
            }
            if (resultArray[tempIndex] == 1) { // O(1)
                return false;
            } else {
                resultArray[tempIndex] = 1;
            }
        }
        return true;
    }
}
