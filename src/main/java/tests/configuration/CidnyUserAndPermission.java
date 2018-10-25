package tests.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyUserAndPermission {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyUserAndPermission.class);

    public CidnyUserAndPermission (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** User & Permission ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.USERANDPERMISSIONLABELXPATH)).getText ();
        String userListStatus = driver.findElement (By.xpath (Configuration.USERANDPERMISSIONCOUNTXPATH)).getText ();
        logger.info ("Status: " + userListStatus);
        String expectedLabel = "User & Permission";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.USERANDPERMISSIONURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.DEPARTMENTURL);
    }
}
