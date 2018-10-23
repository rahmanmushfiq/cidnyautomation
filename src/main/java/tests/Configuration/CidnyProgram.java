package tests.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Configuration;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProgram {
    private WebDriver driver;
    WebDriverWait wait;

    public CidnyProgram (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        System.out.println ("**** Program ****");
        String actualLabel = driver.findElement (By.xpath (Configuration.programLabelXpath)).getText ();
        String programListStatus = driver.findElement (By.xpath (Configuration.programCountXpath)).getText ();
        System.out.println ("Status: " + programListStatus);
        String expectedLabel = "Program";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.programUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        Thread.sleep (3000);
        driver.get (ProjectLinks.designationUrl);
    }
}
