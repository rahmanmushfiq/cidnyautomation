package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyDesignation {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyDesignation.class);


    public CidnyDesignation (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Designation ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.DESIGNATIONLABELXPATH)).getText ();
        String designationListStatus = driver.findElement (By.xpath (Configuration.DESIGNATIONCOUNTXPATH)).getText ();
        logger.info ("Status: " + designationListStatus);
        String expectedLabel = "Designation";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.DESIGNATIONURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.ACCOMMODATIONURL);
    }
}
