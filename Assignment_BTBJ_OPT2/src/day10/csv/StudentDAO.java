package day10.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final String PHONE_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private final String EMAIL_REGEX = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    public List<Student> getAllStudentFromFileCSV(String path) {
        List<Student> students = new ArrayList<>();
        CSVUtils.read(path).forEach(s -> {students.add(parseStringToStudent(s.split(",")));});
        return students;
    }

    public Student parseStringToStudent(String[] arr) {
       return new Student(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]));
    }

    public void checkDataFromFileCSV(String path) {
        List<String> strings = CSVUtils.read(path);
        List<Error> errors = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String[] arr = strings.get(i).split(",");
            if (!arr[2].matches(PHONE_REGEX) && !arr[3].matches(EMAIL_REGEX)) {
                errors.add(new Error("Line "+ i,"co loi sai dinh dang StdPhone,StdEmail"));
            } else if (!arr[2].matches(PHONE_REGEX)){
                errors.add(new Error("Line "+ i,"co loi sai dinh dang StdPhone"));
            } else if (!arr[3].matches(EMAIL_REGEX)) {
                errors.add(new Error("Line "+i,"co loi dinh dang sai StdEmail"));
            }
        }
        CSVUtils.write("src/day10/csv/errors.txt",errors);
    }
}
