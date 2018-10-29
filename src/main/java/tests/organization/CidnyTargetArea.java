package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyTargetArea {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyTargetArea.class);


    public CidnyTargetArea (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Target Area ****");
        String actualLabel = driver.findElement (By.xpath (Organization.TARGETAREALABELXPATH)).getText ();
        String targetAreaListStatus = driver.findElement (By.xpath (Organization.TARGETAREACOUNTXPATH)).getText ();
        logger.info ("Status: " + targetAreaListStatus);
        String expectedLabel = "Target Area";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.TARGETAREAURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.SERVICESURL);
    }
}
