package tests.personnel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PersonnelPageElement;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyPersonnelDetails {
    private static WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyPersonnelDetails.class);

    public CidnyPersonnelDetails (WebDriver driver) {
        CidnyPersonnelDetails.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Personnel ****");
        String actualLabel = driver.findElement (By.xpath (PersonnelPageElement.PERSONNELDETAILSLABELXPATH)).getText ();
        String personnelListStatus = driver.findElement (By.xpath (PersonnelPageElement.PERSONNELDETAILSCOUNTXPATH)).getText ();
        logger.info ("Status: " + personnelListStatus);
        String expectedLabel = "Personnel Details";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PERSONNELURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.LINEITEMSURL);
    }
}
