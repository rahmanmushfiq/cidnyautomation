package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyEmploymentStatus {
    private final WebDriver driver;

    public CidnyEmploymentStatus (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Employment Status ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.employmentStatusLabelXpath)).getText ();
        String expectedLabel = "Employment Status";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.employmentUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.organizationProfileUrl);
    }
}
