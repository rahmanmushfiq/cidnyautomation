package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyFunding {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyFunding.class);


    public CidnyFunding (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Funding ****");
        String actualLabel = driver.findElement (By.xpath (Organization.FUNDINGLABELXPATH)).getText ();
        String fundingListStatus = driver.findElement (By.xpath (Organization.FUNDINGCOUNTXPATH)).getText ();
        logger.info ("Status: " + fundingListStatus);
        String expectedLabel = "Funding";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.FUNDSURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.TARGETAREAURL);
    }
}
