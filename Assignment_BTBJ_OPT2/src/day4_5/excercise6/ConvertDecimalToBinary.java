package day4_5.excercise6;

import java.util.Scanner;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a: ");
        int a = scanner.nextInt();
        String result =  convertDecimalToBinaryString(a);

        System.out.println(a);
        System.out.println(result);

    }

    public static String convertDecimalToBinaryString(int a) {
        String temp = "";
        String result = "";
        while (a!=0) {
            temp += ""+ a%2;
            a = a/2;
        }
        for (int i = temp.length()-1; i >=0 ; i--) {
            result += temp.charAt(i);
        }
        return result;
    }
    
}
