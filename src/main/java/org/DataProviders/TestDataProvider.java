package org.DataProviders;

import org.testng.annotations.DataProvider;
import org.utilities.ExcelReader;

import java.io.IOException;

public class TestDataProvider {
    @DataProvider(name = "loginDataExcel")
    public static Object[][] getLoginData() throws IOException {
        return ExcelReader.getDataFromExcel();
    }
}
