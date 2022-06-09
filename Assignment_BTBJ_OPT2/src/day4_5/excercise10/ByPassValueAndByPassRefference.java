package day4_5.excercise10;

import java.util.Arrays;

public class ByPassValueAndByPassRefference {
    public static void main(String[] args) {
//        By Pass Value
        int a = 10;
        System.out.println(a);
        changeA(a);
        System.out.println(a);
//        By Pass Refference
        int[] b = {1,4,7,8,4};
        System.out.println(Arrays.toString(b));
        changeB(b);
        System.out.println(Arrays.toString(b));

    }

    public static void changeA(int a) {
        a = 20;
    }

    public static void changeB(int[] b) {
        b[2] = 10;
    }
}
