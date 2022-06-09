package day4_5.excercise5;

import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a: ");
        int a = scanner.nextInt();
        System.out.println("Enter number b: ");
        int b = scanner.nextInt();
        System.out.println(findGreatestCommonDivisor(a,b));
        System.out.println(findLeastCommonMultiple(a,b));

    }

    public static int findGreatestCommonDivisor(int a, int b) {
        if (a==0||b==0) {
            return Math.max(a,b);
        }
        int divisor = (a%b==0||b%a==0)?Math.min(a,b):0;
        if (divisor!=0) {
            return divisor;
        } else {
            for (int i = 1; i <=(Math.min(a, b)); i++) {
                if (a%i==0 && b%i==0) {
                    divisor = i;
                }
            }
        }
        return divisor;
    }

    public static int findLeastCommonMultiple(int a, int b) {
        if (a==0||b==0) {
            return 0;
        }
        int multiple = (a%b==0||b%a==0)?Math.max(a,b):0;
        if (multiple!=0) {
            return multiple;
        } else {
            for (int i = Math.max(a,b); true; i++) {
                if (i%a==0&&i%b==0) {
                    multiple = i;
                    return multiple;
                }
            }
        }
    }
}
