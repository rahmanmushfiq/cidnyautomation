package tests.programactivity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProgramActivity;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProgramActivity {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProgramActivity.class);

    public CidnyProgramActivity (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Program Activity ****");
        String actualLabel = driver.findElement (By.xpath (ProgramActivity.PROGRAMACTIVITYLABELXPATH)).getText ();
        String programActivityListStatus = driver.findElement (By.xpath (ProgramActivity.PROGRAMACTIVITYCOUNTXPATH)).getText ();
        logger.info ("Status: " + programActivityListStatus);
        String expectedLabel = "Program Activity";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PROGRAMACTIVITYURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.ADVOCACYMANAGEMENTURL);
    }
}
