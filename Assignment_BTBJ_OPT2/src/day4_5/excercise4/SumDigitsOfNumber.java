package day4_5.excercise4;

import java.util.Scanner;

public class SumDigitsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m: ");
        int m = scanner.nextInt();
        int sum = 0;
        int volume = 1;
        while (m!=0) {
            sum+= m%10;
            volume*=m%10;
            m= m/10;
        }
        System.out.println(sum);
        System.out.println(volume);
    }
}
