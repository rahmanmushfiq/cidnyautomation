package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyServices {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyServices.class);


    public CidnyServices (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Services ****");
        String actualLabel = driver.findElement (By.xpath (Organization.SERVICESLABELXPATH)).getText ();
        String expectedLabel = "Services";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.SERVICESURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PERSONNELURL);
    }
}
