package tests.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TrainingManagement;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyTrainingManagement {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyTrainingManagement.class);

    public CidnyTrainingManagement (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Training Management ****");
        String actualLabel = driver.findElement (By.xpath (TrainingManagement.TRAININGMANAGEMENTLABELXPATH)).getText ();
        String trainingManagementListStatus = driver.findElement (By.xpath (TrainingManagement.TRAININGMANAGEMENTCOUNTXPATH)).getText ();
        logger.info ("Status: " + trainingManagementListStatus);
        String expectedLabel = "Training Management";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.TRAININGMANAGEMENTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PROGRAMACTIVITYURL);
    }

}
