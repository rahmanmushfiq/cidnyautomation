package tests.casemanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CaseManagement;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCaseManagement {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyCaseManagement.class);

    public CidnyCaseManagement (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Case Management ****");
        String actualLabel = driver.findElement (By.xpath (CaseManagement.CASEMANAGEMENTLABELXPATH)).getText ();
        String caseListStatus = driver.findElement (By.xpath (CaseManagement.CASEMANAGEMENTCOUNTXPATH)).getText ();
        logger.info ("Status: " + caseListStatus);
        String expectedLabel = "Case Management";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.CASEMANAGEMENTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.EXTERNALORGURL);
    }

}
