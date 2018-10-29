package tests.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ExternalTrainer;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyExternalTrainer {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyExternalTrainer.class);

    public CidnyExternalTrainer (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** External Trainer ****");
        String actualLabel = driver.findElement (By.xpath (ExternalTrainer.EXTERNALTRAINERLABELXPATH)).getText ();
        String externalTrainerListStatus = driver.findElement (By.xpath (ExternalTrainer.EXTERNALTRAINERCOUNTXPATH)).getText ();
        logger.info ("Status: " + externalTrainerListStatus);
        String expectedLabel = "External Trainer";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.EXTERNALTRAINERURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.TRAININGMANAGEMENTURL);
    }
}
