package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyBoardOfDirector {
    private final WebDriver driver;

    public CidnyBoardOfDirector (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Board Of Directors ****");
        String actualLabel = driver.findElement (By.xpath (Organization.boardOfDirectorsLabelXpath)).getText ();
        String bodListStatus = driver.findElement (By.xpath (Organization.boardOfDirectorsCountXpath)).getText ();
        System.out.println ("Status: " + bodListStatus);
        String expectedLabel = "Board Of Directors";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.bodUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.committeeUrl);
    }
}
