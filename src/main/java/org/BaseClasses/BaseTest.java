package org.BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up WebDriver (Chrome)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // ✅ Initialize the WebDriver
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName() + "_failure.png");
        }
        else{
            if(driver != null){
                driver.quit();
            }
        }
    }

    //Screenshot Capture
    public void captureScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\Akansha Singh\\Downloads\\ck-project\\SeleniumCode\\src\\main\\resources");
        FileUtils.copyFile(screenshot,destination);
    }
}
