package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyUserAndPermission {
    private WebDriver driver;
    WebDriverWait wait;

    public CidnyUserAndPermission (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        System.out.println ("**** User & Permission ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.userAndPermissionLabelXpath)).getText ();
        String expectedLabel = "User & Permission";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.userAndPermissionUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        Thread.sleep (3000);
        driver.get (ProjectLinks.departmentUrl);
    }
}
