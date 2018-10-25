package tests.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCorporateDocs {
    private final WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyCorporateDocs.class);

    public CidnyCorporateDocs (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Corporate Documents ****");
        String actualLabel = driver.findElement (By.xpath (Organization.CORPORATEDOCSLABELXPATH)).getText ();
        String corDocsListStatus = driver.findElement (By.xpath (Organization.CORPORATEDOCSCOUNTXPATH)).getText ();
        logger.info ("Status: " + corDocsListStatus);
        String expectedLabel = "Corporate Documents";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.CORPORATEDOCSURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);

        driver.get (ProjectLinks.BODURL);
    }
}
