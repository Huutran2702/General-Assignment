package candidate.app.view;

import candidate.app.model.Candidate;
import candidate.app.model.Experience;
import candidate.app.model.Fresher;
import candidate.app.model.Intern;
import candidate.app.service.CandidateDAO;
import candidate.app.service.ICandidateDAO;
import candidate.app.utils.WriteLogUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateView {
    public final Logger logger = WriteLogUtils.setLogger("src/candidate/app/ErrorLog.log",Exception.class.getName());
    public final Scanner scanner = new Scanner(System.in);
    public final ICandidateDAO candidateDAO = new CandidateDAO();
    void showAllCandidate() {
        System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ CHỌN ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
        System.out.println("✿                                              ✿");
        System.out.println("✿   1. Xem danh sách tất cả ứng viên           ✿");
        System.out.println("✿   2. Xem danh sách ứng viên Experience       ✿");
        System.out.println("✿   3. Xem danh sách ứng viên Fresher          ✿");
        System.out.println("✿   4. Xem danh sách ứng viên Intern           ✿");
        System.out.println("✿   5. Quay lại                                ✿");
        System.out.println("✿   6. Thoát                                   ✿");
        System.out.println("✿                                              ✿");
        System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
        System.out.print(" ⭆ ");
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getAllCandidate();
                    break;
                case 2:
                    getAllExperience();
                    break;
                case 3:
                    getAllFresher();
                    break;
                case 4:
                    getAllIntern();
                    break;
                case 5:
                    Menu.showMenu();
                    break;
                case 6:
                    Menu.exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại ");
                    showAllCandidate();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.out.println("The system has encountered an unexpected problem, sincerely sorry");
        }

    }

    private void getAllIntern() {
        List<Intern> interns = new ArrayList<>();
        candidateDAO.getAllCandidate().forEach(candidate -> {if(candidate instanceof Intern){
            boolean add = interns.add((Intern) candidate);
            candidate.showInfo();
        }} );

        boolean check = true;
        do {
            scanner.nextLine();
            System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String choice = scanner.nextLine();
            scanner.nextLine();
            switch (choice) {
                case "q":
                    showAllCandidate();
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

    private void getAllFresher() {
        List<Fresher> freshers = new ArrayList<>();
        candidateDAO.getAllCandidate().forEach(candidate -> {if(candidate instanceof Fresher){
            boolean add = freshers.add((Fresher) candidate);
            candidate.showInfo();
        }} );
        boolean check = true;
        do {
            scanner.nextLine();
            System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "q":
                    showAllCandidate();
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

    private void getAllExperience() {
        List<Experience> experiences = new ArrayList<>();
        candidateDAO.getAllCandidate().forEach(candidate -> {if(candidate instanceof Experience){
            boolean add = experiences.add((Experience) candidate);
            candidate.showInfo();
        }} );
        boolean check = true;
        do {
            scanner.nextLine();
            System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "q":
                    showAllCandidate();
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

    private void getAllCandidate() {
        List<Candidate> candidates = candidateDAO.getCandidateUsingCollectionSort();
        for (Candidate c: candidates
        ) {
            c.showInfo();
        }
        boolean check = true;
        do {
            scanner.nextLine();
            System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "q":
                    showAllCandidate();
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


}
