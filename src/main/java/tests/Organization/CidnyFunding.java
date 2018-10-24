package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyFunding {
    private final WebDriver driver;

    public CidnyFunding (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Funding ****");
        String actualLabel = driver.findElement (By.xpath (Organization.fundingLabelXpath)).getText ();
        String fundingListStatus = driver.findElement (By.xpath (Organization.fundingCountXpath)).getText ();
        System.out.println ("Status: " + fundingListStatus);
        String expectedLabel = "Funding";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.fundsUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.targetAreaUrl);
    }
}
