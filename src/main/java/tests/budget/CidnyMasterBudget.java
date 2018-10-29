package tests.budget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Budget;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyMasterBudget {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyMasterBudget.class);

    public CidnyMasterBudget (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Master Budget ****");
        String actualLabel = driver.findElement (By.xpath (Budget.MASTERBUDGETLABELPATH)).getText ();
        String expectedLabel = "Master Budget";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.MASTERBUDGETURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PROGRAMBUDGETURL);
    }
}
