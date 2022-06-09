package day4_5.excercise1;

public class TriangleTower {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n;j++) {
                if(j<=i) {
                    System.out.print("*");
                }

            }
            System.out.println("");
        }
    }
}
