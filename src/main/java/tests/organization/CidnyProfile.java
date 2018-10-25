package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProfile {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProfile.class);

    public CidnyProfile (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Profile ****");
        String actualLabel = driver.findElement (By.xpath (Organization.PROFILELABELXPATH)).getText ();
        String expectedLabel = "Profile";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.ORGANIZATIONPROFILEURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.CORPORATEDOCSURL);
    }
}
