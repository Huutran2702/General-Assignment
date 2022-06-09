package candidate.app.model;

import java.util.Date;

public class Certificate {
    private String certificatedID;
    private String certificatedName;
    private String certificatedRank;
    private Date certificatedDate;
    private String candidateID;

    public Certificate(String certificatedID, String certificatedName, String certificatedRank, Date certificatedDate, String candidateID) {
        this.certificatedID = certificatedID;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
        this.candidateID = candidateID;
    }

    public Certificate() {
    }

    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificatedName() {
        return certificatedName;
    }

    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }

    public String getCertificatedRank() {
        return certificatedRank;
    }

    public void setCertificatedRank(String certificatedRank) {
        this.certificatedRank = certificatedRank;
    }

    public Date getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(Date certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificatedID='" + certificatedID + '\'' +
                ", certificatedName='" + certificatedName + '\'' +
                ", certificatedRank='" + certificatedRank + '\'' +
                ", certificatedDate=" + certificatedDate +
                ", candidateID='" + candidateID + '\'' +
                '}';
    }
}
