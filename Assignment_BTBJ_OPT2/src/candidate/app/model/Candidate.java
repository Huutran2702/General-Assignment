package candidate.app.model;

import java.util.Date;

public abstract class Candidate {
    private String candidateID;
    private String fullName;
    private Date birthDay;
    private String phone;
    private String email;
    private int candidateType;
    public static int candidateCount;

    static {
        candidateCount = 0;
    }

    public Candidate(String candidateID, String fullName,
                     Date birthDay, String phone, String email,
                     int candidateType) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        candidateCount++;
    }

    public Candidate() {
        candidateCount++;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return  "CandidateID= " + candidateID +
                ", FullName= " + fullName  +
                ", BirthDay= " + birthDay  +
                ", Phone= " + phone+
                ", Email=" + email ;

    }
}
