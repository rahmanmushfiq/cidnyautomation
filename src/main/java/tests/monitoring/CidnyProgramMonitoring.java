package tests.monitoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Monitoring;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProgramMonitoring {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProgramMonitoring.class);

    public CidnyProgramMonitoring (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Program Monitoring ****");
        String actualLabel = driver.findElement (By.xpath (Monitoring.PROGRAMMONITORINGLABELXPATH)).getText ();
        String expectedLabel = "Program Monitoring";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PROGRAMMONITORINGURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.BASEURL);
    }
}
