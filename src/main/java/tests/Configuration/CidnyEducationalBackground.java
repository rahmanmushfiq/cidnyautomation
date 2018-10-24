package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyEducationalBackground {
    private WebDriver driver;

    public CidnyEducationalBackground (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Educational Background ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.educationalBackgroundLabelXpath)).getText ();
        String expectedLabel = "Educational Background";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.educationalUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.employmentUrl);
    }
}
