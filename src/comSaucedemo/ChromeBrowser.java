package comSaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        //Creating object for the Chrome browser
        WebDriver driver = new ChromeDriver();

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
