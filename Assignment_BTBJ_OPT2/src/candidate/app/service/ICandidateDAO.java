package candidate.app.service;

import candidate.app.model.*;

import java.util.List;
import java.util.Map;

public interface ICandidateDAO {
        void insertExperience(Experience experience);
        void insertFresher(Fresher fresher);
        void insertIntern(Intern intern);
        boolean existCandidate(String id);
        List<Candidate> getAllCandidate();
        Map<String,Candidate> getCandidateNotExistID();
        List<Candidate> getCandidateUsingCollectionSort();
        void insertCandidateByResultSet(Candidate candidate);
        void updateCandidateByResultSet(Candidate candidate);

}
