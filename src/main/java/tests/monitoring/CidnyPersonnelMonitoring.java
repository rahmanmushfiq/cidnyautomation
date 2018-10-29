package tests.monitoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Monitoring;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyPersonnelMonitoring {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyPersonnelMonitoring.class);

    public CidnyPersonnelMonitoring (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Personnel Monitoring ****");
        String actualLabel = driver.findElement (By.xpath (Monitoring.PERSONNELMONITORINGLABELXPATH)).getText ();
        String expectedLabel = "Personnel Monitoring";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PERSONNELMONITORINGURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PROGRAMMONITORINGURL);
    }
}
