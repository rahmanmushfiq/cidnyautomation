package tests.budget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Budget;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyExpense {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyExpense.class);

    public CidnyExpense (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Expense ****");
        String actualLabel = driver.findElement (By.xpath (Budget.EXPENSELABELXPATH)).getText ();
        String expenseListStatus = driver.findElement (By.xpath (Budget.EXPENSECOUNTXPATH)).getText ();
        logger.info ("Status: " + expenseListStatus);
        String expectedLabel = "Expense";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.EXPENSEURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.PROJECTURL);
    }
}
