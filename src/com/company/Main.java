package com.company;

import java.util.Scanner;

public class Main {
final static Scanner scanner = new Scanner(System.in);

    private static void add (int[][] matrix1, int[][] matrix2, int rows, int columns){
        int[][] addition = new int[rows][columns];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < columns; j++) {
                addition[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(j == columns - 1 ? addition[i][j] + "\n" : addition[i][j] + " ");
            }
        }
    }
    public static void main(String[] args) {
        // first matrix
        int row1 = scanner.nextInt();
        int column1 = scanner.nextInt();
        int[][] matrix1 = new int[row1][column1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        // second matrix
        int row2 = scanner.nextInt();
        int column2 = scanner.nextInt();
        int[][] matrix2 = new int[row2][column2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < column2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        if (row1 != row2 || column1 != column2) {
            System.out.println("ERROR");
        } else {
            add(matrix1, matrix2, row1, column1);
        }
    }
}
