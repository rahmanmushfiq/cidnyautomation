package tests.monitoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Monitoring;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyFinancialMonitoring {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyFinancialMonitoring.class);

    public CidnyFinancialMonitoring (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Financial Monitoring ****");
        String actualLabel = driver.findElement (By.xpath (Monitoring.FINANCIALMONITORINGLABELXPATH)).getText ();
        String expectedLabel = "Financial Monitoring";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.FINANCIALMONITORINGURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PERSONNELMONITORINGURL);
    }
}
