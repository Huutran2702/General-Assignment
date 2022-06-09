package day4_5.excercise7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManipulatingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string s: ");
        String s = scanner.nextLine();
        while (s.equals("")) {
            System.out.println("The string you entered is not valid! Please re-enter: ");
            s = scanner.nextLine();
        }
//        Câu a
        System.out.println(s);
        System.out.println(reverse(s));
//        Câu b
        System.out.println(s.toUpperCase());
//        Câu c
        System.out.println(s.toLowerCase());
//        Câu d
        Map<Character,Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i)==' ') {
                continue;
            }
            if (frequency.get(s.charAt(i))==null) {
                frequency.put(s.charAt(i),1);
            } else {
                frequency.put(s.charAt(i), frequency.get(s.charAt(i))+1);
            }
        }
        System.out.println(frequency);
//        Câu e
        int n,m;
        do{
            System.out.println("Enter n: ");
            n = scanner.nextInt();
            System.out.println("Enter m: ");
            m = scanner.nextInt();
        }while (n>s.length()||m>s.length());
        String result = (m>n)?s.substring(n,m):s.substring(m,n);
        System.out.println(result);
    }

    public static String reverse(String s) {
        String result = "";
        if (s.length()==1) {
            return s;
        }else {
            for (int i = s.length()-1; i >=0 ; i--) {
                result += s.charAt(i);
            }
            return result;
        }
    }



}
