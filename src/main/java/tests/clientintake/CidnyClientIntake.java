package tests.clientintake;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ClientIntake;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyClientIntake {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyClientIntake.class);

    public CidnyClientIntake (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Client Intake ****");
        String actualLabel = driver.findElement (By.xpath (ClientIntake.CLIENTINTAKELABELXPATH)).getText ();
        String clientListStatus = driver.findElement (By.xpath (ClientIntake.CLIENTINTAKECOUNTXPATH)).getText ();
        logger.info ("Status: " + clientListStatus);
        String expectedLabel = "Client Intake";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.CLIENTINTAKEURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.CASEMANAGEMENTURL);
    }
}
