package com.epam.arrays;

import java.util.Arrays;

public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        zeroMatrix.zeroMatrix(new int[][]{
                {4, 2, 8, 8, 4, 0},
                {9, 3, 5, 9, 4, 5},
                {7, 9, 9, 0, 7, 2},
                {3, 8, 5, 8, 9, 1},
                {8, 7, 6, 4, 6, 3},
                {3, 1, 8, 3, 5, 0}
        });
    }

    private void zeroMatrix(int[][] matrix) {

        int zeroItemsCount = 0;

        for (int[] ints : matrix) { // O(NM)
            for (int anInt : ints) {
                if (anInt == 0) {
                    zeroItemsCount++;
                }
            }
        }

        int[] zeroRowItemsIndex = new int[zeroItemsCount];
        int[] zeroColumnItemsIndex = new int[zeroItemsCount];
        int currentZeroItemsIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowItemsIndex[currentZeroItemsIndex] = i;
                    zeroColumnItemsIndex[currentZeroItemsIndex] = j;
                    currentZeroItemsIndex++;
                }
            }
        }

        System.out.println(Arrays.toString(zeroRowItemsIndex));
        System.out.println(Arrays.toString(zeroColumnItemsIndex));

        for (int rowItemsIndex : zeroRowItemsIndex) { // O (KM), K = zeroRowItemsIndex length
            for (int j = 0; j < matrix[rowItemsIndex].length; j++) {
                matrix[rowItemsIndex][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) { // O(NL), L - zeroColumnItemsIndex length
            for(int j = 0; j < zeroColumnItemsIndex.length; j++) {
                matrix[i][zeroColumnItemsIndex[j]] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Total:
        // O(NM + NL + KM), K, L << N, M => O(NM)
    }
}
