package day4_5.excercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecimalFactorialSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.get(0).equals(new Object());
        System.out.println("Enter number n: ");
        int n = scanner.nextInt();
        float sum = 0.0f;
        float factorial = 1f;
        for (int i = 1; i <= (2*n-1); i+=2) {
            for(int j = 1; j<=i;j++ ) {
                factorial *= j;
            }

            sum +=1/factorial ;
        }
        System.out.println(sum);
    }
}
