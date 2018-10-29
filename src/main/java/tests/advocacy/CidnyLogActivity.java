package tests.advocacy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Advocacy;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyLogActivity {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyLogActivity.class);

    public CidnyLogActivity (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Log Activity ****");
        String actualLabel = driver.findElement (By.xpath (Advocacy.LOGACTIVITYLABELXPATH)).getText ();
        String logActivityListStatus = driver.findElement (By.xpath (Advocacy.LOGACTIVITYCOUNTXPATH)).getText ();
        logger.info ("Status: " + logActivityListStatus);
        String expectedLabel = "Log Activity";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.LOGACTIVITYURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.FINANCIALMONITORINGURL);
    }
}
