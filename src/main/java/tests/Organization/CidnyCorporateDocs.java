package tests.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Organization;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCorporateDocs {
    private WebDriver driver;

    public CidnyCorporateDocs (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Corporate Documents ****");
        String actualLabel = driver.findElement (By.xpath (Organization.corporateDocsLabelXpath)).getText ();
        String corDocsListStatus = driver.findElement (By.xpath (Organization.corporateDocsCountXpath)).getText ();
        System.out.println ("Status: " + corDocsListStatus);
        String expectedLabel = "Corporate Documents";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.corporateDocsUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);

        driver.get (ProjectLinks.bodUrl);
    }
}
