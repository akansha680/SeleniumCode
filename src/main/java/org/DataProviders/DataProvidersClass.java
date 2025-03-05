package org.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {

    @DataProvider(name="loginData")
    public Object[][] dataProv(){
        return new Object[][] {
                {"Admin","admin123"},
                {"verma.ayush@ck.com","Ayush@8493"}
        };
    }
}
