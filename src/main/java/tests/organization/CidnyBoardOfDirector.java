package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyBoardOfDirector {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyBoardOfDirector.class);


    public CidnyBoardOfDirector (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Board Of Directors ****");
        String actualLabel = driver.findElement (By.xpath (Organization.BOARDOFDIRECTORSLABELXPATH)).getText ();
        String bodListStatus = driver.findElement (By.xpath (Organization.BOARDOFDIRECTORSCOUNTXPATH)).getText ();
        logger.info ("Status: " + bodListStatus);
        String expectedLabel = "Board Of Directors";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.BODURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.COMMITTEEURL);
    }
}
