package day10.csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new StudentDAO().getAllStudentFromFileCSV("src/day10/csv/STD.csv");
        students.forEach(System.out::println);
       new StudentDAO().checkDataFromFileCSV("src/day10/csv/STD.csv");
    }
}
