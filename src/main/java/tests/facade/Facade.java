package tests.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.net.www.protocol.http.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class Facade {
    private Facade () {

    }

    private static final Logger logger = LogManager.getLogger (Facade.class);
    private static int serial = 1;

    public static void verifyLabelAndUrl (String expectedLabel, String actualLabel, String expectedUrl, String actualUrl) {
        Assert.assertEquals (expectedLabel, actualLabel);
        Assert.assertEquals (expectedUrl, actualUrl);
        logger.info ("Page Label is Verified as: " + actualLabel);
        logger.info ("Page URL is Verified as: " + actualUrl);
    }

    public static void checkBrokenLinks (WebDriver driver) {
        List<WebElement> links = driver.findElements (By.tagName ("a"));
        logger.info ("Total " + (links.size () - 1) + " Links found !");
        for (int i = 1; i < links.size (); i++) {
            WebElement element = links.get (i);
            logger.info (serial + ": ");
            String url = element.getAttribute ("href");
            serial++;
            verifyUrl (url);
        }
    }

    private static void verifyUrl (String url) {
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter
            URL link = new URL (url);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection ();
            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout (2000);
            //connect using connect method
            httpConn.connect ();
            //use getResponseCode() to get the response code.
            if (httpConn.getResponseCode () == 200) {
                System.out.println (url + " - " + httpConn.getResponseMessage ());
            }
            if (httpConn.getResponseCode () == 404) {
                System.out.println (url + " - " + httpConn.getResponseMessage ());
            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server.
        catch (Exception e) {
            logger.error ("Exception: " + e);
        }
    }
}
