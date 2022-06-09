package candidate.app;

import candidate.app.model.*;
import candidate.app.repository.CandidateRepository;
import candidate.app.service.CandidateDAO;
import candidate.app.utils.SQLServerConnectionUtils;
import candidate.app.utils.ValidateUtils;
import candidate.app.utils.WriteLogUtils;
import candidate.app.view.Menu;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
       Menu.showMenu();

    }


}
