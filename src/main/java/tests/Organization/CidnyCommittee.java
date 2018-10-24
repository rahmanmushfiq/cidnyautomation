package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCommittee {
    private WebDriver driver;

    public CidnyCommittee (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Committee ****");
        String actualLabel = driver.findElement (By.xpath (Organization.committeesLabelXpath)).getText ();
        String committeeListStatus = driver.findElement (By.xpath (Organization.committeeCountXpath)).getText ();
        System.out.println ("Status: " + committeeListStatus);
        String expectedLabel = "Committee";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.committeeUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.sourceUrl);
    }
}
