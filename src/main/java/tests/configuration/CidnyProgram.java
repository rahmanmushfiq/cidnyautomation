package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProgram {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProgram.class);

    public CidnyProgram (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Program ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.PROGRAMLABELXPATH)).getText ();
        String programListStatus = driver.findElement (By.xpath (Configuration.PROGRAMCOUNTXPATH)).getText ();
        logger.info ("Status: " + programListStatus);
        String expectedLabel = "Program";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PROGRAMURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);

        driver.get (ProjectLinks.DESIGNATIONURL);
    }
}
