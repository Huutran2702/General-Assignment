package day4_5.excercise11;

public class CommentsAndJavaDoc {
    public static void main(String[] args) {
    /*
        Comment thường được sử dụng để mô tả một hoặc nhiều dòng lệnh
        Còn JavaDoc thường dùng để mô ta phương thức hoặc lớp

     */
        // Ví dụ :
        printLine(10);

    }

    /**
     * Hàm dùng để in ra một số nguyên a
     * @param a - Tham số truyền vào là một số nguyên a
     */
    public static void printLine(int a) {
        System.out.println(a);
    }
}
