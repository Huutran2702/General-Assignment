package candidate.app.view;

import candidate.app.exception.BirthDayException;
import candidate.app.exception.EmailException;
import candidate.app.model.*;
import candidate.app.service.CandidateDAO;
import candidate.app.service.ICandidateDAO;
import candidate.app.utils.ValidateUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final CandidateView candidateView = new CandidateView();
    public static void showMenu() {
            System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ CHỌN ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
            System.out.println("✿                                              ✿");
            System.out.println("✿   1. Thêm ứng viên mới                       ✿");
            System.out.println("✿   2. Xem số lượng ứng viên vừa nhập          ✿");
            System.out.println("✿   3. Xem danh sách ứng viên                  ✿");
            System.out.println("✿   4. Xem tất cả tên ứng viên                 ✿");
            System.out.println("✿   5. Thêm mới và cập nhật bằng result set    ✿");
            System.out.println("✿   6. Thoát                                   ✿");
            System.out.println("✿                                              ✿");
            System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
            System.out.print(" ⭆ ");
            int choice = candidateView.scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewCandidate();
                    break;
                case 2:
                    showCandidateQuantityInput();
                    break;
                case 3:
                    candidateView.showAllCandidate();
                    break;
                case 4:
                    getAllFullName();
                    break;
                case 5:
                    ManipulatingResultSetView.insertAndUpdateByResultSet();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại ");
                    showMenu();
            }
        }




    private static void showCandidateQuantityInput() {
        System.out.println("Số lượng ứng viên vừa nhập :" +Candidate.candidateCount);
        boolean check = true;
        do {
            candidateView.scanner.nextLine();
            System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String choice = candidateView.scanner.nextLine();
           candidateView.scanner.nextLine();
            switch (choice) {
                case "q":
                    Menu.showMenu();
                    break;
                case "t":
                    Menu.exit();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhấn không đúng! vui lòng chọn lại");
                    check = false;
            }
        } while (!check);
    }

    private static void addNewCandidate() {
        try {
            System.out.println("Nhập id của ứng viên");
            System.out.print(" ⭆ ");
            String candidateID = candidateView.scanner.next();
            candidateView.scanner.nextLine();

            if (candidateView.candidateDAO.existCandidate(candidateID)) {
                System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                addNewCandidate();
            } else {
                System.out.println("Nhập họ và tên của ứng viên");
                System.out.print(" ⭆ ");
                String fullName = candidateView.scanner.nextLine();
                Date birthDaySQL = null;
                String birthDay = "";
                try {
                    System.out.println("Nhập ngày tháng năm sinh của ứng viên - cú pháp \"yyyy-mm-dd\"");
                    System.out.print(" ⭆ ");
                    birthDay = candidateView.scanner.nextLine();
                    if (!ValidateUtils.isBirthDayValid(birthDay)) {
                        throw new BirthDayException("Ngày tháng năm sinh không đúng định dạng - năm sinh phải từ năm 1900 đến hiện tại!");
                    }
                } catch (BirthDayException e) {
                    candidateView.logger.error(e.getMessage());
                    while (!ValidateUtils.isBirthDayValid(birthDay)) {
                        System.out.println(e.getMessage());
                        System.out.println("Nhập ngày tháng năm sinh của ứng viên - cú pháp \"yyyy-mm-dd\"");
                        System.out.print(" ⭆ ");
                        birthDay = candidateView.scanner.nextLine();
                    }
                } finally {
                    birthDaySQL = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthDay).getTime());
                }
                System.out.println("Nhập số điện thoại (vd: 0345129876): ");
                System.out.print(" ⭆ ");
                String phone = candidateView.scanner.nextLine();
                String email = null;
                try {
                    System.out.println("Nhập email (vd: thuan@gmail.com)");
                    System.out.print(" ⭆ ");
                    email = candidateView.scanner.nextLine();
                    if (!ValidateUtils.isEmailValid(email)) {
                        throw new EmailException("Email không đúng định dạng! Vui lòng nhập lại ! ");
                    }
                } catch (EmailException e) {
                    candidateView.logger.error(e.getMessage());
                    while (!ValidateUtils.isEmailValid(email)) {
                        System.out.println(e.getMessage());
                        System.out.println("Nhập email (vd: thuan@gmail.com)");
                        System.out.print(" ⭆ ");
                        email = candidateView.scanner.nextLine();
                    }
                }
               boolean checkCandidateType = true;
                do {
                    System.out.println("Nhập kiểu ứng viên đăng ký - 0: Experience, 1: Fresher , 2: Intern ");
                    System.out.print(" ⭆ ");
                    int candidateType = candidateView.scanner.nextInt();
                    switch (candidateType) {
                        case 0:
                            System.out.println("Nhập số năm kinh nghiệm của ứng viên: ");
                            System.out.print(" ⭆ ");
                            int expInYear = candidateView.scanner.nextInt();
                            candidateView.scanner.nextLine();
                            System.out.println("Nhập kỹ năng chuyên môn của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String proSkill = candidateView.scanner.nextLine();
                            Experience experience = new Experience(candidateID,fullName,birthDaySQL,phone,email,expInYear,proSkill);
                            candidateView.candidateDAO.insertExperience(experience);
                            checkCandidateType = false;
                            break;
                        case 1:
                            candidateView.scanner.nextLine();
                            System.out.println("Nhập thời gian tốt nghiệp của ứng viên - cú pháp \"yyyy-mm-dd\"");
                            System.out.print(" ⭆ ");
                            String graduationDate = candidateView.scanner.next();
                            Date graduationDateSQL = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(graduationDate).getTime());
                            candidateView.scanner.nextLine();
                            System.out.println("Nhập xếp loại tốt nghiệp của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String graduationRank = candidateView.scanner.nextLine();
                            candidateView.scanner.nextLine();
                            System.out.println("Nhập trường tốt nghiệp của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String education = candidateView.scanner.nextLine();
                            Fresher fresher = new Fresher(candidateID,fullName,birthDaySQL,phone,email,graduationDateSQL,graduationRank,education);
                            candidateView.candidateDAO.insertFresher(fresher);
                            checkCandidateType = false;
                            break;
                        case 2:
                            candidateView.scanner.nextLine();
                            System.out.println("Nhập chuyên ngành đang học của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String majors = candidateView.scanner.nextLine();
                            System.out.println(majors);
                            System.out.println("Nhập học kỳ đang học của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String semester = candidateView.scanner.nextLine();
                            System.out.println("Nhập trường đang học của ứng viên: ");
                            System.out.print(" ⭆ ");
                            String universityName = candidateView.scanner.nextLine();
                            Intern intern = new Intern(candidateID,fullName,birthDaySQL,phone,email,majors,semester,universityName);
                            candidateView.candidateDAO.insertIntern(intern);
                            checkCandidateType = false;
                            break;
                        default:
                            System.out.println("Nhập kiểu ứng viên chưa phù hợp - vui lòng nhập lại: ");
                    }
                } while (checkCandidateType);

                System.out.println("Đã thêm thành công! ");
                System.out.println("Số lượng ứng viên vừa thêm vào là : " + Candidate.candidateCount);
            }
            boolean check = true;
            do {
                System.out.println("Nhấn 'y' để thêm tiếp ứng viên \t|\t 'q' để quay lại \t|\t 't' để thoát");
                System.out.print(" ⭆ ");
                String choice = candidateView.scanner.nextLine();
                switch (choice) {
                    case "y":
                        addNewCandidate();
                        break;
                    case "q":
                        showMenu();
                        break;
                    case "t":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        check = false;
                }
            } while (!check);
        } catch (Exception e) {
            candidateView.logger.error(e.getMessage());
            System.out.println("The system has encountered an unexpected problem, sincerely sorry ");
        }
    }

    public static void getAllFullName() {
        StringBuffer fullNames = new StringBuffer();
        List<Candidate> candidates = candidateView.candidateDAO.getAllCandidate();
        candidates.forEach(candidateDTO -> fullNames.append(candidateDTO.getFullName()).append(","));
        System.out.println(fullNames);
    }


    public static void exit () {
        System.out.println("\tTạm biệt. Hẹn gặp lại!");
        System.exit(3);
    }




}
