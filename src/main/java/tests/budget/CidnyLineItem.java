package tests.budget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Budget;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyLineItem {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger (CidnyLineItem.class);

    public CidnyLineItem (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Line Item ****");
        String actualLabel = driver.findElement (By.xpath (Budget.LINEITEMLABEXPATH)).getText ();
        String lineItemListStatus = driver.findElement (By.xpath (Budget.LINEITEMCOUNTPATH)).getText ();
        logger.info ("Status: " + lineItemListStatus);
        String expectedLabel = "Line Item";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.LINEITEMSURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.MASTERBUDGETURL);
    }

}
