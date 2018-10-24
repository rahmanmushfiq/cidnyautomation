package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnySpecialAccommodation {
    private final WebDriver driver;

    public CidnySpecialAccommodation (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Special Accommodation ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.specialAccommodationLabelXpath)).getText ();
        String expectedLabel = "Special Accommodation";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.accommodationUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.educationalUrl);
    }
}
