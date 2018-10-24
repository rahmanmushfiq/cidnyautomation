package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyFundSource {
    private final WebDriver driver;

    public CidnyFundSource (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Fund Source ****");
        String actualLabel = driver.findElement (By.xpath (Organization.fundSourceLabelXpath)).getText ();
        String sourceListStatus = driver.findElement (By.xpath (Organization.fundSourceCountXpath)).getText ();
        System.out.println ("Status: " + sourceListStatus);
        String expectedLabel = "Fund Source";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.sourceUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.fundsUrl);
    }

}
