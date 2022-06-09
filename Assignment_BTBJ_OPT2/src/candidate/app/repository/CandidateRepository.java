package candidate.app.repository;

import candidate.app.model.*;
import candidate.app.utils.SQLServerConnectionUtils;
import candidate.app.utils.WriteLogUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateRepository implements ICandidateRepository{
    private Logger logger = WriteLogUtils.setLogger("src/candidate/app/InfoLog.log",Candidate.class.getName());

    private static final String INSERT_CANDIDATE_SQL = "INSERT INTO Candidate (candidateID, fullName, birthDay, phone," +
            " email, candidateType, expInYear, proSkill, graduationDate, graduationRank, education, " +
            "majors, semester, universityName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CANDIDATE_BY_CANDIDATE_ID = "SELECT * FROM Candidate WHERE candidateID = ?";
    private static final String SELECT_ALL_CANDIDATE = "SELECT * FROM Candidate ";
    @Override
    public void insertExperience(Experience experience) {
        try (Connection connection = SQLServerConnectionUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)) {
            preparedStatement.setString(1, experience.getCandidateID());
            preparedStatement.setString(2, experience.getFullName());
            preparedStatement.setDate(3, (Date) experience.getBirthDay());
            preparedStatement.setString(4, experience.getPhone());
            preparedStatement.setString(5, experience.getEmail());
            preparedStatement.setInt(6, experience.getCandidateType());
            preparedStatement.setInt(7, experience.getExpInYear());
            preparedStatement.setString(8, experience.getProSkill());
            preparedStatement.setString(9, null);
            preparedStatement.setString(10,null);
            preparedStatement.setString(11, null);
            preparedStatement.setString(12, null);
            preparedStatement.setString(13, null);
            preparedStatement.setString(14, null);
            preparedStatement.executeUpdate();
            logger.info(INSERT_CANDIDATE_SQL);

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insertFresher(Fresher fresher) {
        try (Connection connection = SQLServerConnectionUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)) {
            preparedStatement.setString(1, fresher.getCandidateID());
            preparedStatement.setString(2, fresher.getFullName());
            preparedStatement.setDate(3, (Date) fresher.getBirthDay());
            preparedStatement.setString(4, fresher.getPhone());
            preparedStatement.setString(5, fresher.getEmail());
            preparedStatement.setInt(6, fresher.getCandidateType());
            preparedStatement.setString(7, null);
            preparedStatement.setString(8, null);
            preparedStatement.setDate(9, (Date) fresher.getGraduationDate());
            preparedStatement.setString(10,fresher.getGraduationRank());
            preparedStatement.setString(11, fresher.getEducation());
            preparedStatement.setString(12, null);
            preparedStatement.setString(13, null);
            preparedStatement.setString(14, null);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            logger.info(INSERT_CANDIDATE_SQL);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insertIntern(Intern intern) {
        try (Connection connection = SQLServerConnectionUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)) {
            preparedStatement.setString(1, intern.getCandidateID());
            preparedStatement.setString(2, intern.getFullName());
            preparedStatement.setDate(3, (Date) intern.getBirthDay());
            preparedStatement.setString(4, intern.getPhone());
            preparedStatement.setString(5, intern.getEmail());
            preparedStatement.setInt(6, intern.getCandidateType());
            preparedStatement.setString(7, null);
            preparedStatement.setString(8, null);
            preparedStatement.setDate(9, null);
            preparedStatement.setString(10,null);
            preparedStatement.setString(11, null);
            preparedStatement.setString(12, intern.getMajors());
            preparedStatement.setString(13, intern.getSemester());
            preparedStatement.setString(14, intern.getUniversityName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            logger.info(INSERT_CANDIDATE_SQL);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public boolean existCandidate(String id) {
        try (Connection connection = SQLServerConnectionUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CANDIDATE_BY_CANDIDATE_ID)) {
            preparedStatement.setString(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

           if (rs.next()) {
               return true;
           }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    @Override
    public List<Candidate> getAllCandidate() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection connection = SQLServerConnectionUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CANDIDATE)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            logger.info(SELECT_ALL_CANDIDATE);
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String candidateID = rs.getString("candidateID");
                String fullName = rs.getString("fullName");
                Date birthDay = rs.getDate("birthDay");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int candidateType = rs.getInt("candidateType");
                int expInYear = rs.getInt("expInYear");
                String proSkill = rs.getString("proSkill");
                Date graduationDate = rs.getDate("graduationDate");
                String graduationRank = rs.getString("graduationRank");
                String education = rs.getString("education");
                String majors = rs.getString("majors");
                String semester = rs.getString("semester");
                String universityName = rs.getString("universityName");
                if (candidateType == 0) {
                    Experience experience = new Experience(candidateID,fullName,birthDay,phone,email,expInYear,proSkill);
                    candidates.add(experience);
                } else if (candidateType == 1 ) {
                    Fresher fresher = new Fresher(candidateID,fullName,birthDay,phone,email,graduationDate,graduationRank,education);
                    candidates.add(fresher);
                } else {
                    Intern intern = new Intern(candidateID,fullName,birthDay,phone,email,majors,semester,universityName);
                    candidates.add(intern);
                }

            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return candidates;
    }

    @Override
    public void insertCandidateByResultSet(Candidate candidate) {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection connection = SQLServerConnectionUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement stmt = connection.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE)) {
            // Step 3: Execute the query or update query

            ResultSet rs = stmt.executeQuery(SELECT_ALL_CANDIDATE);
            logger.info(SELECT_ALL_CANDIDATE);

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                String candidateID = rs.getString("candidateID");
//                String fullName = rs.getString("fullName");
//                Date birthDay = rs.getDate("birthDay");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//                int candidateType = rs.getInt("candidateType");
//                int expInYear = rs.getInt("expInYear");
//                String proSkill = rs.getString("proSkill");
//                Date graduationDate = rs.getDate("graduationDate");
//                String graduationRank = rs.getString("graduationRank");
//                String education = rs.getString("education");
//                String majors = rs.getString("majors");
//                String semester = rs.getString("semester");
//                String universityName = rs.getString("universityName");
//                if (candidateType == 0) {
//                    Experience experience = new Experience(candidateID,fullName,birthDay,phone,email,expInYear,proSkill);
//                    candidates.add(experience);
//                } else if (candidateType == 1 ) {
//                    Fresher fresher = new Fresher(candidateID,fullName,birthDay,phone,email,graduationDate,graduationRank,education);
//                    candidates.add(fresher);
//                } else {
//                    Intern intern = new Intern(candidateID,fullName,birthDay,phone,email,majors,semester,universityName);
//                    candidates.add(intern);
//                }
            }
            rs.moveToInsertRow();
            rs.updateString("candidateID",candidate.getCandidateID());
            rs.updateString("fullName",candidate.getFullName());
            rs.updateDate("birthDay", (Date) candidate.getBirthDay());
            rs.updateString("phone",candidate.getPhone());
            rs.updateString("email",candidate.getEmail());
            rs.updateInt("candidateType",candidate.getCandidateType());
            if (candidate instanceof Experience) {
                rs.updateInt("expInYear",((Experience) candidate).getExpInYear());
                rs.updateString("proSkill",((Experience) candidate).getProSkill());
            }
            if (candidate instanceof Fresher) {
                rs.updateDate("graduationDate", (Date) ((Fresher) candidate).getGraduationDate());
                rs.updateString("graduationRank",((Fresher) candidate).getGraduationRank());
                rs.updateString("education",((Fresher) candidate).getEducation());
            }
            if (candidate instanceof Intern) {
                rs.updateString("majors",((Intern) candidate).getMajors());
                rs.updateString("semester",((Intern) candidate).getSemester());
                rs.updateString("universityName",((Intern) candidate).getUniversityName());
            }
            rs.insertRow();


        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateCandidateByResultSet(Candidate candidate) {
        try (Connection connection = SQLServerConnectionUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement stmt = connection.createStatement(
                     ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_UPDATABLE)) {
            // Step 3: Execute the query or update query

            ResultSet rs = stmt.executeQuery(SELECT_ALL_CANDIDATE);
            logger.info(SELECT_ALL_CANDIDATE);
            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                if ( rs.getString("candidateID").equals(candidate.getCandidateID())) {
                    rs.updateString("fullName",candidate.getFullName());
                    rs.updateDate("birthDay", (Date) candidate.getBirthDay());
                    rs.updateString("phone",candidate.getPhone());
                    rs.updateString("email",candidate.getEmail());
                    rs.updateInt("candidateType",candidate.getCandidateType());
                    if (candidate instanceof Experience) {
                        rs.updateInt("expInYear",((Experience) candidate).getExpInYear());
                        rs.updateString("proSkill",((Experience) candidate).getProSkill());
                        rs.updateDate("graduationDate",null);
                        rs.updateString("graduationRank",null);
                        rs.updateString("education",null);
                        rs.updateString("majors",null);
                        rs.updateString("semester",null);
                        rs.updateString("universityName",null);
                    }
                    if (candidate instanceof Fresher) {
                        rs.updateString("expInYear",null);
                        rs.updateString("proSkill",null);
                        rs.updateDate("graduationDate", (Date) ((Fresher) candidate).getGraduationDate());
                        rs.updateString("graduationRank",((Fresher) candidate).getGraduationRank());
                        rs.updateString("education",((Fresher) candidate).getEducation());
                        rs.updateString("majors",null);
                        rs.updateString("semester",null);
                        rs.updateString("universityName",null);
                    }
                    if (candidate instanceof Intern) {
                        rs.updateString("expInYear",null);
                        rs.updateString("proSkill",null);
                        rs.updateDate("graduationDate",null);
                        rs.updateString("graduationRank",null);
                        rs.updateString("education",null);
                        rs.updateString("majors",((Intern) candidate).getMajors());
                        rs.updateString("semester",((Intern) candidate).getSemester());
                        rs.updateString("universityName",((Intern) candidate).getUniversityName());
                    }
                    rs.updateRow();
                }

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
