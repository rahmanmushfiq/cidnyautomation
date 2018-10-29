package tests.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ExternalOrganization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyExternalOrganization {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyExternalOrganization.class);

    public CidnyExternalOrganization (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** External Organization ****");
        String actualLabel = driver.findElement (By.xpath (ExternalOrganization.EXTERNALORGLABELXPATH)).getText ();
        String externalOrgListStatus = driver.findElement (By.xpath (ExternalOrganization.EXTERNALORGCOUNTXPATH)).getText ();
        logger.info ("Status: " + externalOrgListStatus);
        String expectedLabel = "External Organization";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.EXTERNALORGURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.EXTERNALTRAINERURL);
    }
}
