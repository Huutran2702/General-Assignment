package day4_5.excercise2;

import java.util.Scanner;

public class DecimalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number n: ");
        int n = scanner.nextInt();
        float sum = 0.0f;
        for (float i = 1; i < n+1; i++) {
            sum +=  1/i;
        }
        System.out.println(sum);
    }
}
