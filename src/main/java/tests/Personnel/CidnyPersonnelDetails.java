package tests.Personnel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PersonnelPageElement;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyPersonnelDetails {
    private static WebDriver driver;

    public CidnyPersonnelDetails (WebDriver driver) {
        CidnyPersonnelDetails.driver = driver;
    }

    public void verifyLabelAndUrl () {

        System.out.println ("**** Personnel ****");
        String actualLabel = driver.findElement (By.xpath (PersonnelPageElement.personnelDetailsLabelXpath)).getText ();
        String expectedLabel = "Personnel Details";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.personnelUrl;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
    }
}
