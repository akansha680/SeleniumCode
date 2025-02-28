package org.Tests;

import org.BaseClasses.BaseTest;
import org.example.LoginPage;
import org.testng.annotations.Test;
import org.DataProviders.DataProvidersClass;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProvidersClass.class)  // ✅ Using correct DataProvider
    public void loginTest(String userName, String password) {
        // Create an instance of LoginPage and pass the WebDriver instance
        LoginPage loginPage = new LoginPage(driver);

        // Perform login action using Page Object methods
        loginPage.login(userName, password);

        // Verify login success
        if (loginPage.isLoginSuccessful()) {
            System.out.println("Login successful for: " + userName);
        } else {
            System.out.println("Login failed for: " + userName);
        }
    }
}
