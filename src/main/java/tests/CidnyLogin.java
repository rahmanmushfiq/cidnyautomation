package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPageElements;
import pages.credentials.Credentials;
import pages.links.ProjectLinks;
import tests.facade.Facade;

class CidnyLogin {
    private static WebDriver driver;
    private static String baseUrl;
    private static final String TITLE = "CIDNY";
    private static final Logger logger = LogManager.getLogger (CidnyLogin.class);

    public CidnyLogin (WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public static void validateLogin () {
        logger.info ("Base URL is: " + baseUrl);
        try {
            driver.get (baseUrl);
            driver.findElement (By.xpath (LoginPageElements.EMAILXPATH)).sendKeys (Credentials.VALIDEMAIL);
            driver.findElement (By.xpath (LoginPageElements.PASSXPATH)).sendKeys (Credentials.VALIDPASS);
            driver.findElement (By.id (LoginPageElements.LOGINBUTTONID)).click ();
            Thread.sleep (2000);
            driver.navigate ().refresh ();
            Thread.sleep (5000);

            String title = driver.getTitle ();
            if (title.equals (TITLE)) {
                logger.info ("Successfully Logged In !");
                logger.info ("Page Title is: " + title);
            } else {
                throw new Exception ();
            }
        } catch (Exception e) {
            logger.error ("Login Exception: " + e.getStackTrace ());
        }
        String dashboardUrl = driver.getCurrentUrl ();
        logger.info ("Dashboard URL: " + dashboardUrl);
    }

    public static void printAllLinks () throws InterruptedException {
        Facade.checkBrokenLinks (driver);
        Thread.sleep (3000);
        driver.get (ProjectLinks.USERANDPERMISSIONURL);
    }
}
