package candidate.app.model;

import java.util.Date;

public class Fresher extends Candidate {
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String candidateID, String fullName, Date birthDay,
                   String phone, String email, Date graduationDate,
                   String graduationRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher() {
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString()+", candidateType = Fresher" + ", graduationDate=" + graduationDate +
                ", graduationRank=" + graduationRank+", education="+education );
    }
}
