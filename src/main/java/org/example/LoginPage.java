package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By username = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Added explicit wait
    }

    // Page Actions with Explicit Wait
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    // Method to verify successful login
    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.urlContains("/dashboard/index"));
    }
}
