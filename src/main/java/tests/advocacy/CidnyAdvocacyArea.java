package tests.advocacy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Advocacy;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyAdvocacyArea {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyAdvocacyArea.class);

    public CidnyAdvocacyArea (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Advocacy Area ****");
        String actualLabel = driver.findElement (By.xpath (Advocacy.ADVOCACYAREALABELXPATH)).getText ();
        String advocacyAreaListStatus = driver.findElement (By.xpath (Advocacy.ADVOCACYAREACOUNTXPATH)).getText ();
        logger.info ("Status: " + advocacyAreaListStatus);
        String expectedLabel = "Advocacy Area";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.ADVOCACYAREAURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.LOGACTIVITYURL);
    }
}
