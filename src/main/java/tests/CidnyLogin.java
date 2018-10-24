package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPageElements;
import pages.links.ProjectLinks;
import tests.facade.Facade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CidnyLogin {
    private static WebDriver driver;
    public static String baseUrl;
    public int serial = 1;
    private static final String dateTime = LocalDateTime.now ().format (DateTimeFormatter.ISO_LOCAL_TIME);

    public CidnyLogin (WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public static void validateLogin () throws InterruptedException {
        System.out.println ("Base URL is: " + baseUrl);
        System.out.println ("Test Started at: " + dateTime);

        driver.get (baseUrl);
        driver.findElement (By.xpath (LoginPageElements.emailXpath)).sendKeys (LoginPageElements.validEmail);
        driver.findElement (By.xpath (LoginPageElements.passXpath)).sendKeys (LoginPageElements.validPass);
        driver.findElement (By.id (LoginPageElements.loginButtonId)).click ();
        Thread.sleep (5000);

//        Cookie cookie = new Cookie ("customCookie", "12345");
//        driver.manage ().addCookie (cookie);
//        Set<Cookie> cookies = driver.manage ().getCookies ();
//        for (Cookie cooks : cookies) {
//            System.out.println (cooks);
//        }

        System.out.println ("Successfully Logged In !");
        String title = driver.getTitle ();
        String dashboardUrl = driver.getCurrentUrl ();
        System.out.println ("Page Title is: " + title);
        System.out.println ("Dashboard URL: " + dashboardUrl);

        /*
        Store Cookie for re-login
         */

    }

    public static void printAllLinks () throws InterruptedException {
        Facade.checkBrokenLinks (driver);
        Thread.sleep (3000);
        driver.get (ProjectLinks.userAndPermissionUrl);
    }
}
