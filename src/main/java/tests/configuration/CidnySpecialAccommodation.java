package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnySpecialAccommodation {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnySpecialAccommodation.class);


    public CidnySpecialAccommodation (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Special Accommodation ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.SPECIALACCOMMODATIONLABELXPATH)).getText ();
        String expectedLabel = "Special Accommodation";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.ACCOMMODATIONURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.EDUCATIONALURL);
    }
}
