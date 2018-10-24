package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProfile {
    private final WebDriver driver;

    public CidnyProfile (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Profile ****");
        String actualLabel = driver.findElement (By.xpath (Organization.profileLabelXpath)).getText ();
        String expectedLabel = "Profile";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.organizationProfileUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);

        driver.get (ProjectLinks.corporateDocsUrl);
    }
}
