package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPageElements;
import pages.links.ProjectLinks;
import tests.facade.Facade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CidnyLogin {
    private static WebDriver driver;
    private static String baseUrl;
    private int serial = 1;
    private static final String DATETIME = LocalDateTime.now ().format (DateTimeFormatter.ISO_LOCAL_TIME);
    static Logger logger = LogManager.getLogger (CidnyLogin.class);

    public CidnyLogin (WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public static void validateLogin () throws InterruptedException {
        logger.info ("Base URL is: " + baseUrl);
        logger.info ("Test Started at: " + DATETIME);

        driver.get (baseUrl);
        driver.findElement (By.xpath (LoginPageElements.EMAILXPATH)).sendKeys (LoginPageElements.VALIDEMAIL);
        driver.findElement (By.xpath (LoginPageElements.PASSXPATH)).sendKeys (LoginPageElements.VALIDPASS);
        driver.findElement (By.id (LoginPageElements.LOGINBUTTONID)).click ();
        Thread.sleep (5000);

        logger.info ("Successfully Logged In !");
        String title = driver.getTitle ();
        String dashboardUrl = driver.getCurrentUrl ();
        logger.info ("Page Title is: " + title);
        logger.info ("Dashboard URL: " + dashboardUrl);

    }

    public static void printAllLinks () throws InterruptedException {
        Facade.checkBrokenLinks (driver);
        Thread.sleep (3000);
        driver.get (ProjectLinks.USERANDPERMISSIONURL);
    }
}
