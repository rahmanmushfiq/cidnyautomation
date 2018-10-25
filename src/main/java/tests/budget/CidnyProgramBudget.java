package tests.budget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Budget;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProgramBudget {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProgramBudget.class);

    public CidnyProgramBudget (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Program Budget ****");
        String actualLabel = driver.findElement (By.xpath (Budget.PROGRAMBUDGETLABELPATH)).getText ();
        String expectedLabel = "Program Budget";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PROGRAMBUDGETURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.EXPENSEURL);
    }
}
