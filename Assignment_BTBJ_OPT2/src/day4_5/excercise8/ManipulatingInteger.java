package day4_5.excercise8;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Scanner;

public class ManipulatingInteger {
    public static Scanner scanner = new Scanner(System.in);
    public static StringBuilder printMessage = new StringBuilder("Enter element ");
    public static void main(String[] args) {
        System.out.println("Enter size array: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            printMessage = new StringBuilder("Enter element ");
            System.out.println(printMessage.append(i).append(":"));
            a[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(a));
        System.out.println(sumTotalOddInteger(a));
        System.out.println("Enter number to check index: ");
        int k = scanner.nextInt();
        System.out.println(getAllIndexOfNumber(k,a));
        System.out.println(Arrays.toString(sortArray(a)));
        System.out.println(Arrays.toString(insert(1,a)));
    }

    /**
     * Tính tổng những số nguyên lẻ trong mảng
     * @param arr
     * @return sum
     */
    public static int sumTotalOddInteger(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2!=0) {
                sum+=arr[i];
            }
        }
        return sum;
    }

    /**
     * Nhập vào phần tử k, tìm xem k có xuất hiện trong mảng a không.
     * Nếu có chỉ ra các vị trí của k trong mảng.
     * @param k Nhập từ bàn phím
     * @param arr tham số truyền vào
     * @return Chuỗi String chứa các index của k
     */
    public static String getAllIndexOfNumber(int k, int[] arr) {
        StringBuilder allIndex = new StringBuilder("Index of number "+k+" is: ");
        boolean isExist = false;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==k) {
              allIndex.append(i).append(" ");
              if (!isExist) {
                  isExist = true;
              }
            }
        }
        return isExist?allIndex.toString():"array contains no element "+k;
    }

    public static int[] sortArray (int[] arr) {
        int temp = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]<arr[j]) {
                    temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] insert(int p, int[] arr) {
        int[] temp = new int[arr.length+1];
        for (int i = 0; i <arr.length ; i++) {
            temp[i] = arr[i];
        }
        temp[arr.length] = p;
        return sortArray(temp);
    }


}