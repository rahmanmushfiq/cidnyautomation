package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCommittee {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyCommittee.class);


    public CidnyCommittee (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Committee ****");
        String actualLabel = driver.findElement (By.xpath (Organization.COMMITTEESLABELXPATH)).getText ();
        String committeeListStatus = driver.findElement (By.xpath (Organization.COMMITTEECOUNTXPATH)).getText ();
        logger.info ("Status: " + committeeListStatus);
        String expectedLabel = "Committee";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.COMMITTEEURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.SOURCEURL);
    }
}
