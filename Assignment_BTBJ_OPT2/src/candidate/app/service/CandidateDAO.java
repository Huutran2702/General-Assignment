package candidate.app.service;

import candidate.app.model.Candidate;
import candidate.app.model.Experience;
import candidate.app.model.Fresher;
import candidate.app.model.Intern;
import candidate.app.repository.CandidateRepository;
import candidate.app.repository.ICandidateRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateDAO implements ICandidateDAO {
    private final ICandidateRepository candidateRepository = new CandidateRepository();

    @Override
    public void insertExperience(Experience experience) {
        candidateRepository.insertExperience(experience);
    }

    @Override
    public void insertFresher(Fresher fresher) {
        candidateRepository.insertFresher(fresher);
    }

    @Override
    public void insertIntern(Intern intern) {
        candidateRepository.insertIntern(intern);
    }

    @Override
    public boolean existCandidate(String id) {
        return candidateRepository.existCandidate(id);
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return candidateRepository.getAllCandidate();
    }

    @Override
    public Map<String, Candidate> getCandidateNotExistID() {
        Map<String, Candidate> map = new HashMap<>();
        new CandidateDAO().getAllCandidate().forEach(candidate -> map.putIfAbsent(candidate.getCandidateID(), candidate));
        return map;
    }

    @Override
    public List<Candidate> getCandidateUsingCollectionSort() {
        List<Candidate> candidates = getAllCandidate();
        candidates.sort((Comparator.comparing(Candidate::getCandidateType).thenComparing(candidate -> candidate.getBirthDay().getTime())));
        return candidates;
    }

    @Override
    public void insertCandidateByResultSet(Candidate candidate) {
        candidateRepository.insertCandidateByResultSet(candidate);
    }

    @Override
    public void updateCandidateByResultSet(Candidate candidate) {
        candidateRepository.updateCandidateByResultSet(candidate);
    }
}
