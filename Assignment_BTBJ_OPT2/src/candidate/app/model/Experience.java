package candidate.app.model;

import java.util.Date;

public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience(String candidateID, String fullName, Date birthDay, String phone, String email,
                       int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience() {
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString()+", candidateType = Experience" + ", expInYear=" + expInYear +
                ", proSkill=" + proSkill );
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} " + super.toString();
    }
}
