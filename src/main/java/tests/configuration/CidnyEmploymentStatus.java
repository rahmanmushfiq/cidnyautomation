package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyEmploymentStatus {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyEmploymentStatus.class);


    public CidnyEmploymentStatus (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Employment Status ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.EMPLOYMENTSTATUSLABELXPATH)).getText ();
        String expectedLabel = "Employment Status";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.EMPLOYMENTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.ORGANIZATIONPROFILEURL);
    }
}
