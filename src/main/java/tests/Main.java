package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.links.ProjectLinks;
import tests.advocacy.CidnyAdvocacyArea;
import tests.advocacy.CidnyAdvocacyManagement;
import tests.advocacy.CidnyLogActivity;
import tests.budget.CidnyExpense;
import tests.budget.CidnyLineItem;
import tests.budget.CidnyMasterBudget;
import tests.budget.CidnyProgramBudget;
import tests.casemanagement.CidnyCaseManagement;
import tests.clientintake.CidnyClientIntake;
import tests.configuration.*;
import tests.monitoring.CidnyFinancialMonitoring;
import tests.monitoring.CidnyPersonnelMonitoring;
import tests.monitoring.CidnyProgramMonitoring;
import tests.organization.*;
import tests.personnel.CidnyPersonnelDetails;
import tests.programactivity.CidnyProgramActivity;
import tests.projects.CidnyProjects;
import tests.training.CidnyExternalOrganization;
import tests.training.CidnyExternalTrainer;
import tests.training.CidnyTrainingManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static WebDriver driver;
    private static String browser;
    private static final String PROJECTPATH = System.getProperty ("user.dir");
    private static final String OS = System.getProperty ("os.name");
    private static final String TIME = LocalDateTime.now ().format (DateTimeFormatter.ISO_LOCAL_TIME);
    private static Logger logger = LogManager.getLogger (Main.class);

    /**
     * For Windows Operating System
     */
    private static final String WINCHROMEDRIVERPATH = PROJECTPATH + "\\drivers\\chromedriver\\chromedriver.exe";
    private static final String WINGECKODRIVERPATH = PROJECTPATH + "\\drivers\\firefoxdriver\\geckodriver.exe";
    private static final String WINEDGEDRIVERPATH = PROJECTPATH + "\\drivers\\edgedriver\\MicrosoftWebDriver.exe";

    /**
     * For Linux Operating System
     */
    private static final String LINUXCHROMEDRIVERPATH = PROJECTPATH + "/drivers/chromedriver/chromedriver";
    private static final String LINUXGECKODRIVERPATH = PROJECTPATH + "/drivers/firefoxdriver/geckodriver";

    /*
    Driver Keys
     */
    private static final String CHROMEDRIVERKEY = "webdriver.chrome.driver";
    private static final String GECKODRIVERKEY = "webdriver.gecko.driver";
    private static final String EDGEDRIVERKEY = "webdriver.edge.driver";

    public static void main (String[] args) throws Exception {
        while (true) {
            setBrowser ();
            if (setBrowserConfig ()) {
                break;
            }
        }

        CidnyLogin cidnyLogin = new CidnyLogin (driver, ProjectLinks.BASEURL);
        cidnyLogin.validateLogin ();
        cidnyLogin.printAllLinks ();

        CidnyUserAndPermission cidnyUserAndPermission = new CidnyUserAndPermission (driver);
        cidnyUserAndPermission.verifyLabelAndUrl ();

        CidnyDepartment cidnyDepartment = new CidnyDepartment (driver);
        cidnyDepartment.verifyLabelAndUrl ();

        CidnyProgram cidnyProgram = new CidnyProgram (driver);
        cidnyProgram.verifyLabelAndUrl ();

        CidnyDesignation cidnyDesignation = new CidnyDesignation (driver);
        cidnyDesignation.verifyLabelAndUrl ();

        CidnySpecialAccommodation cidnySpecialAccommodation = new CidnySpecialAccommodation (driver);
        cidnySpecialAccommodation.verifyLabelAndUrl ();

        CidnyEducationalBackground cidnyEducationalBackground = new CidnyEducationalBackground (driver);
        cidnyEducationalBackground.verifyLabelAndUrl ();

        CidnyEmploymentStatus cidnyEmploymentStatus = new CidnyEmploymentStatus (driver);
        cidnyEmploymentStatus.verifyLabelAndUrl ();

        CidnyProfile cidnyProfile = new CidnyProfile (driver);
        cidnyProfile.verifyLabelAndUrl ();

        CidnyCorporateDocs cidnyCorporateDocs = new CidnyCorporateDocs (driver);
        cidnyCorporateDocs.verifyLabelAndUrl ();

        CidnyBoardOfDirector cidnyBoardOfDirector = new CidnyBoardOfDirector (driver);
        cidnyBoardOfDirector.verifyLabelAndUrl ();

        CidnyCommittee cidnyCommittee = new CidnyCommittee (driver);
        cidnyCommittee.verifyLabelAndUrl ();

        CidnyFundSource cidnyFundSource = new CidnyFundSource (driver);
        cidnyFundSource.verifyLabelAndUrl ();

        CidnyFunding cidnyFunding = new CidnyFunding (driver);
        cidnyFunding.verifyLabelAndUrl ();

        CidnyTargetArea cidnyTargetArea = new CidnyTargetArea (driver);
        cidnyTargetArea.verifyLabelAndUrl ();

        CidnyServices cidnyServices = new CidnyServices (driver);
        cidnyServices.verifyLabelAndUrl ();

        CidnyPersonnelDetails cidnyPersonnelDetails = new CidnyPersonnelDetails (driver);
        cidnyPersonnelDetails.verifyLabelAndUrl ();

        CidnyLineItem cidnyLineItem = new CidnyLineItem (driver);
        cidnyLineItem.verifyLabelAndUrl ();

        CidnyMasterBudget cidnyMasterBudget = new CidnyMasterBudget (driver);
        cidnyMasterBudget.verifyLabelAndUrl ();

        CidnyProgramBudget cidnyProgramBudget = new CidnyProgramBudget (driver);
        cidnyProgramBudget.verifyLabelAndUrl ();

        CidnyExpense cidnyExpense = new CidnyExpense (driver);
        cidnyExpense.verifyLabelAndUrl ();

        CidnyProjects cidnyProjects = new CidnyProjects (driver);
        cidnyProjects.verifyLabelAndUrl ();

        CidnyClientIntake cidnyClientIntake = new CidnyClientIntake (driver);
        cidnyClientIntake.verifyLabelAndUrl ();

        CidnyCaseManagement cidnyCaseManagement = new CidnyCaseManagement (driver);
        cidnyCaseManagement.verifyLabelAndUrl ();

        CidnyExternalOrganization cidnyExternalOrganization = new CidnyExternalOrganization (driver);
        cidnyExternalOrganization.verifyLabelAndUrl ();

        CidnyExternalTrainer cidnyExternalTrainer = new CidnyExternalTrainer (driver);
        cidnyExternalTrainer.verifyLabelAndUrl ();

        CidnyTrainingManagement cidnyTrainingManagement = new CidnyTrainingManagement (driver);
        cidnyTrainingManagement.verifyLabelAndUrl ();

        CidnyProgramActivity cidnyProgramActivity = new CidnyProgramActivity (driver);
        cidnyProgramActivity.verifyLabelAndUrl ();

        CidnyAdvocacyManagement cidnyAdvocacyManagement = new CidnyAdvocacyManagement (driver);
        cidnyAdvocacyManagement.verifyLabelAndUrl ();

        CidnyAdvocacyArea cidnyAdvocacyArea = new CidnyAdvocacyArea (driver);
        cidnyAdvocacyArea.verifyLabelAndUrl ();

        CidnyLogActivity cidnyLogActivity = new CidnyLogActivity (driver);
        cidnyLogActivity.verifyLabelAndUrl ();

        CidnyFinancialMonitoring cidnyFinancialMonitoring = new CidnyFinancialMonitoring (driver);
        cidnyFinancialMonitoring.verifyLabelAndUrl ();

        CidnyPersonnelMonitoring cidnyPersonnelMonitoring = new CidnyPersonnelMonitoring (driver);
        cidnyPersonnelMonitoring.verifyLabelAndUrl ();

        CidnyProgramMonitoring cidnyProgramMonitoring = new CidnyProgramMonitoring (driver);
        cidnyProgramMonitoring.verifyLabelAndUrl ();
        tearDown ();
    }

    private static void setBrowser () {
        Scanner input = new Scanner (System.in);
        logger.info ("Which browser do you want to use ? ");
        browser = input.nextLine ();
    }

    private static boolean setBrowserConfig () {
        if (OS.equalsIgnoreCase ("Windows")) {
            try {
                if (browser.equalsIgnoreCase ("Chrome")) {
                    System.setProperty (CHROMEDRIVERKEY, WINCHROMEDRIVERPATH);
                    driver = new ChromeDriver ();
                    return true;
                } else if (browser.equalsIgnoreCase ("Headless")) {
                    System.setProperty (CHROMEDRIVERKEY, WINCHROMEDRIVERPATH);
                    ChromeOptions options = new ChromeOptions ();
                    options.addArguments ("--headless");
                    driver = new ChromeDriver (options);
                    return true;
                } else if (browser.equalsIgnoreCase ("Edge")) {
                    System.setProperty (EDGEDRIVERKEY, WINEDGEDRIVERPATH);
                    driver = new EdgeDriver ();
                    return true;
                } else if (browser.equalsIgnoreCase ("Firefox")) {
                    System.setProperty (GECKODRIVERKEY, WINGECKODRIVERPATH);
                    driver = new FirefoxDriver ();
                    return true;
                }
            } catch (Exception e) {
                logger.fatal ("Exception is: " + e.getMessage ());
                logger.fatal ("Cause is: " + e.getCause ());
            }
        } else if (OS.equalsIgnoreCase ("Linux")) {
            try {
                if (browser.equalsIgnoreCase ("Chrome")) {
                    System.setProperty (CHROMEDRIVERKEY, LINUXCHROMEDRIVERPATH);
                    driver = new ChromeDriver ();
                    return true;
                } else if (browser.equalsIgnoreCase ("Headless")) {
                    System.setProperty (CHROMEDRIVERKEY, LINUXCHROMEDRIVERPATH);
                    ChromeOptions options = new ChromeOptions ();
                    options.addArguments ("--headless");
                    driver = new ChromeDriver (options);
                    return true;
                } else if (browser.equalsIgnoreCase ("Firefox")) {
                    System.setProperty (GECKODRIVERKEY, LINUXGECKODRIVERPATH);
                    driver = new FirefoxDriver ();
                    return true;
                }
            } catch (Exception e) {
                logger.fatal ("Exception is: " + e.getMessage ());
                logger.fatal ("Cause is: " + e.getCause ());
            }
        }
        logger.error ("You have entered an invalid browser name !");
        return false;
    }

    /*
     * quit the browser and clear the session
     */
    private static void tearDown () {
        logger.info ("Test Ended at: " + TIME);
        logger.info (browser + " Browser is Closing....");
        try {
            if (browser.equalsIgnoreCase ("Firefox")) {
                driver.quit ();
            } else {
                driver.close ();
                driver.quit ();
            }
        } catch (Exception e) {
            logger.error ("Exception: " + e);
        }
    }
}

