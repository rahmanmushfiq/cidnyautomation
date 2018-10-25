package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyDepartment {
    private static WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyDepartment.class);

    public CidnyDepartment (WebDriver driver) {
        CidnyDepartment.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Department ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.DEPTLABELXPATH)).getText ();
        String departmentListStatus = driver.findElement (By.xpath (Configuration.DEPTCOUNTXPATH)).getText ();
        logger.info ("Status: " + departmentListStatus);
        String expectedLabel = "Department";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.DEPARTMENTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PROGRAMURL);
    }
}
