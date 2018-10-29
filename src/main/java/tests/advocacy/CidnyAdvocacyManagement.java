package tests.advocacy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Advocacy;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyAdvocacyManagement {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyAdvocacyManagement.class);

    public CidnyAdvocacyManagement (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Advocacy Management ****");
        String actualLabel = driver.findElement (By.xpath (Advocacy.ADVOCACYMANAGEMENTLABELXPATH)).getText ();
        String advocacyManagementListStatus = driver.findElement (By.xpath (Advocacy.ADVOCACYMANAGEMENTCOUNTXPATH)).getText ();
        logger.info ("Status: " + advocacyManagementListStatus);
        String expectedLabel = "Advocacy Management";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.ADVOCACYMANAGEMENTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.ADVOCACYAREAURL);
    }
}
