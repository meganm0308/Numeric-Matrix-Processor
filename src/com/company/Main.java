package com.company;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    // add two matrices with integer elements
    private static void add (double[][] matrix1, double[][] matrix2){
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            double[][] addition = new double[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    addition[i][j] = matrix1[i][j] + matrix2[i][j];
                    System.out.print(j == matrix1[0].length - 1 ? addition[i][j] + "\n" : addition[i][j] + " ");
                }
            }
        }
    }

    // multiply a matrix by a constant
    private static void multiplyByConst (double[][] matrix, double factor) {
        System.out.println("The result is:");
        for (double[] doubles : matrix) {
            for (int j = 0; j < doubles.length; j++) {
                System.out.print(j == doubles.length - 1 ?
                        doubles[j] * factor + "\n" : doubles[j] * factor + " ");
            }
        }
    }

    // multiply 2 matrices
    private static void multiplyMatrices (double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            for (double[] doubles : matrix1) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < matrix2.length; k++) {
                        sum += doubles[k] * matrix2[k][j];
                    }
                    System.out.printf("%.2f ", sum);
                }
                System.out.print("\n");
            }
        }
    }

    private static void transpose (double[][] matrix, int transposeOption) {
        System.out.println("The result is:");
        switch (transposeOption) {
            case 1:
                for (int i = 0; i < matrix[0].length; i++) {
                    for (double[] doubles : matrix) {
                        System.out.print(doubles[i] + " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                for (int i = matrix[0].length - 1; i >= 0; i--) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        System.out.print(matrix[j][i] +  " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                for (double[] doubles : matrix) {
                    for (int j = matrix[0].length - 1; j >= 0; j--) {
                        System.out.print(doubles[j] + " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                for (int i = matrix.length - 1; i >= 0; i--) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                break;
        }
    }

    // take 2 matrices from user input
    private static Matrices take2Matrices () {
        // first matrix
        System.out.println("Enter size of first matrix:");
        int row1 = scanner.nextInt();
        int column1 = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrix1 = new double[row1][column1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }
        // second matrix
        System.out.println("Enter size of second matrix:");
        int row2 = scanner.nextInt();
        int column2 = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] matrix2 = new double[row2][column2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < column2; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }
        return new Matrices(matrix1, matrix2);
    }

    private static double[][] take1Matrix () {
        // first matrix
        System.out.println("Enter size of matrix:");
        int row1 = scanner.nextInt();
        int column1 = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix1 = new double[row1][column1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }
        return matrix1;
    }

    private static void menu () {
        while (true) {
            System.out.println("""
                    1. Add matrices
                    2. Multiply matrix by a constant
                    3. Multiply matrices
                    4. Transpose matrix
                    0. Exit
                    Your choice:""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Matrices matricesToAdd = take2Matrices();
                    add(matricesToAdd.matrix1, matricesToAdd.matrix2);
                }
                case 2 -> {
                    double[][] matrix = take1Matrix();
                    System.out.println("Enter constant:");
                    double constant = scanner.nextDouble();
                    multiplyByConst(matrix, constant);
                }
                case 3 -> {
                    Matrices matricesToMultiply = take2Matrices();
                    multiplyMatrices(matricesToMultiply.matrix1, matricesToMultiply.matrix2);
                }
                case 4 -> {
                    System.out.println("""
                            1. Main diagonal
                            2. Side diagonal
                            3. Vertical line
                            4. Horizontal line
                            Your choice:""");
                    int transposeOption = scanner.nextInt();
                    double[][] matrix = take1Matrix();
                    transpose(matrix, transposeOption);
                }
                case 0 -> System.exit(1);
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }

    }
    public static void main(String[] args) {
        menu();
    }
}