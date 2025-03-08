package org.Tests;

import org.BaseClasses.BaseTest;
import org.DataProviders.TestDataProvider;
import org.Listeners.RetryAnalyzer;
import org.pageObjects.LoginPage;
import org.testng.annotations.Test;
import org.DataProviders.DataProvidersClass;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

//    @Test(dataProvider = "loginData", dataProviderClass = DataProvidersClass.class,retryAnalyzer = RetryAnalyzer.class)  // ✅ Using correct DataProvider
    public void loginTest(String userName, String password) {
        // Create an instance of LoginPage and pass the WebDriver instance
        LoginPage loginPage = new LoginPage(driver);

        // Perform login action using Page Object methods
        loginPage.login(userName, password);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isLoginSuccessful(),"Login is Successful");
    }



    @Test(dataProvider = "loginDataExcel", dataProviderClass = TestDataProvider.class)  // ✅ Using correct DataProvider
    public void excelLoginTest(String userName, String password) {
        // Create an instance of LoginPage and pass the WebDriver instance
        LoginPage loginPage = new LoginPage(driver);

        // Perform login action using Page Object methods
        loginPage.login(userName, password);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isLoginSuccessful(),"Login is Successful");
    }
}
