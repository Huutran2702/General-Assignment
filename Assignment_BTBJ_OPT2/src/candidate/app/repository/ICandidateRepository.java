package candidate.app.repository;

import candidate.app.model.*;

import java.util.List;

public interface ICandidateRepository {
    void insertExperience(Experience experience);
    void insertFresher(Fresher fresher);
    void insertIntern(Intern intern);
    boolean existCandidate(String id);
    List<Candidate> getAllCandidate();
    void insertCandidateByResultSet(Candidate candidate);
    void updateCandidateByResultSet(Candidate candidate);


}
