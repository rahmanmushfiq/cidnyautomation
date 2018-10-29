package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyFundSource {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyFundSource.class);

    public CidnyFundSource (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Fund Source ****");
        String actualLabel = driver.findElement (By.xpath (Organization.FUNDSOURCELABELXPATH)).getText ();
        String sourceListStatus = driver.findElement (By.xpath (Organization.FUNDSOURCECOUNTXPATH)).getText ();
        logger.info ("Status: " + sourceListStatus);
        String expectedLabel = "Fund Source";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.SOURCEURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.FUNDSURL);
    }

}
