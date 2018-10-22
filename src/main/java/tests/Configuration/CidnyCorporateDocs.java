package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyCorporateDocs {
    private WebDriver driver;
    WebDriverWait wait;

    public CidnyCorporateDocs (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        System.out.println ("**** Corporate Documents Category ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.corporateDocsLabelXpath)).getText ();
        String expectedLabel = "Corporate Documents Category";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.corporateDocsCategoryUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        Thread.sleep (3000);
        driver.get (ProjectLinks.baseUrl);
    }
}
