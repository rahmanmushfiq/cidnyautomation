package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyServices {
    private WebDriver driver;

    public CidnyServices (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Services ****");
        String actualLabel = driver.findElement (By.xpath (Organization.servicesLabelXpath)).getText ();
        String expectedLabel = "Services";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.servicesUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.baseUrl);
    }
}
