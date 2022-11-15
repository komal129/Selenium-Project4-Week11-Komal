package comSaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    static String browser = "edge";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {

            if(browser.equalsIgnoreCase("chrome")){

                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                //Creating object for the Chrome browser
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.firefox.driver","drivers/geckodriver.exe");
                // Creating the object for FireFox Browser
                driver = new FirefoxDriver();
            } else if(browser.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.msedgedriver.driver","drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {

                System.out.println("Wrong Browser Name");
            }

            //Launching the URL
            driver.get(baseUrl);

            // Maximise the browser window
            driver.manage().window().maximize();

            // Giving implicit wait time to the driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Getting the page title
            String title = driver.getTitle();
            System.out.println("The page title is: " +title);

            // Getting current URL
            System.out.println("Current URL is: " +driver.getCurrentUrl());

            // Getting page source
            System.out.println("Page source is: " +driver.getPageSource());

            // Find the Username field and enter the username
            WebElement emailField = driver.findElement(By.id("user-name"));
            emailField.sendKeys("standard_user");

            //Find the password field element and enter the password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("secret_sauce");

            // Closing the browser
            driver.quit();
    }
}
