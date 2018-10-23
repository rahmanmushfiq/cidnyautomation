package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyDesignation {
    private WebDriver driver;
    WebDriverWait wait;

    public CidnyDesignation (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        System.out.println ("**** Designation ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.designationLabelXpath)).getText ();
        String designationListStatus = driver.findElement (By.xpath (Configuration.designationCountXpath)).getText ();
        System.out.println ("Status: " + designationListStatus);
        String expectedLabel = "Designation";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.designationUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        Thread.sleep (3000);
        driver.get (ProjectLinks.accommodationUrl);
    }
}
