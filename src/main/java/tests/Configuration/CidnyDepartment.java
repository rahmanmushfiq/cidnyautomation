package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyDepartment {
    private static WebDriver driver;
    WebDriverWait wait;

    public CidnyDepartment (WebDriver driver) {
        CidnyDepartment.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        System.out.println ("**** Department ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.deptLabelXpath)).getText ();
        String departmentListStatus = driver.findElement (By.xpath (Configuration.deptCountXpath)).getText ();
        System.out.println ("Status: " + departmentListStatus);
        String expectedLabel = "Department";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.departmentUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.programUrl);
    }
}
