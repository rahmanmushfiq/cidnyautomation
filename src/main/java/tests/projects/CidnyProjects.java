package tests.projects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Projects;
import pages.links.ProjectLinks;
import tests.facade.Facade;

public class CidnyProjects {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger (CidnyProjects.class);

    public CidnyProjects (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLabelAndUrl () throws InterruptedException {
        Thread.sleep (3000);
        logger.info ("**** Projects ****");
        String actualLabel = driver.findElement (By.xpath (Projects.PROJECTLABELXPATH)).getText ();
        String projectsListStatus = driver.findElement (By.xpath (Projects.PROJECTCOUNTXPATH)).getText ();
        logger.info ("Status: " + projectsListStatus);
        String expectedLabel = "Projects";
        String actualUrl = driver.getCurrentUrl ();
        String expectedUrl = ProjectLinks.PROJECTURL;
        Facade.verifyLabelAndUrl (expectedLabel, actualLabel, expectedUrl, actualUrl);
        driver.get (ProjectLinks.CLIENTINTAKEURL);
    }
}
