package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyEducationalBackground {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyEducationalBackground.class);


    public CidnyEducationalBackground (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Educational Background ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.EDUCATIONALBACKGROUNDLABELXPATH)).getText ();
        String expectedLabel = "Educational Background";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.EDUCATIONALURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.EMPLOYMENTURL);
    }
}
