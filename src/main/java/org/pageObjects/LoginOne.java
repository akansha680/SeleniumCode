package org.pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class LoginOne {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akansha Singh\\Downloads\\ck-project\\SeleniumCode\\chromedriver.exe");

        // Enable headless mode (Optional)
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment for headless mode

        // Instantiate WebDriver
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the Login Page
            String url = "https://app.cloudkeeper.com/";
            driver.get(url);
            driver.manage().window().maximize();

            // Step 2: Locate and Input Username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            usernameField.sendKeys("akansha.singh@cloudkeeper.com");

            // Step 3: Locate and Input Password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("TTNdefault@123");

            // Step 4: Capture Screenshot Before Login
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C:\\Users\\Akansha Singh\\Downloads\\ck-project\\SeleniumCode\\screenshot.png"));

            // Step 5: Locate and Click Login Button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login-btn")));
            loginButton.click();

            // Step 6: Validate Successful Login
            String expectedUrl = "https://app.cloudkeeper.com/dashboard/partner/users";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            if (driver.getCurrentUrl().equals(expectedUrl)) {
                System.out.println("✅ Login Successful!");
            } else {
                System.out.println("❌ Login Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Test Failed due to exception.");
        } finally {
            driver.quit(); // Ensure the browser closes even if an error occurs
        }
    }
}
