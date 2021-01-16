package com.epam.arrays;

public class IsRotation {

    public static void main(String[] args) {
        IsRotation isRotation = new IsRotation();
        System.out.println(isRotation.isRotation("erbottlewat", "waterbottle"));
    }

    // O(AB) solution
    // todo update with KMP
    private boolean isRotation(String a, String b) {

        return b.repeat(2).contains(a);
    }
}
