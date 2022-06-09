package day4_5.excercise9;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of rows of the matrix: ");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns of the matrix: ");
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.println("Enter element  "+j +" of row "+i);
                arr[i][j] = scanner.nextInt();
            }
        }
        int tich = 1;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i]%3==0) {
                tich*=arr[0][i];
            }

        }
        System.out.println(tich);
        int X[] = new int[m];
        for (int i = 0; i <m ; i++) {
            X[i] = findMaxValue(arr[i]);
        }
        System.out.println(Arrays.toString(X));
    }

    public static int findMaxValue(int[] arr) {
        int maxValue = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]>maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
