package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyUserAndPermission {
    private WebDriver driver;

    public CidnyUserAndPermission (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** User & Permission ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.userAndPermissionLabelXpath)).getText ();
        String userListStatus = driver.findElement (By.xpath (Configuration.userAndPermissionCountXpath)).getText ();
        System.out.println ("Status: " + userListStatus);
        String expectedLabel = "User & Permission";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.userAndPermissionUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.departmentUrl);
    }
}
