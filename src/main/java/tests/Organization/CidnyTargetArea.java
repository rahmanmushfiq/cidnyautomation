package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyTargetArea {
    private final WebDriver driver;

    public CidnyTargetArea (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Target Area ****");
        String actualLabel = driver.findElement (By.xpath (Organization.targetAreaLabelXpath)).getText ();
        String targetAreaListStatus = driver.findElement (By.xpath (Organization.targetAreaCountXpath)).getText ();
        System.out.println ("Status: " + targetAreaListStatus);
        String expectedLabel = "Target Area";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.targetAreaUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.servicesUrl);
    }
}
