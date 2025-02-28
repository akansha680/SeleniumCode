package org.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {

    @DataProvider(name="loginData")
    public Object[][] dataProv(){
        return new Object[][] {
                {"akansha.singh@ck.com","Akku@0702"},
                {"verma.ayush@ck.com","Ayush@8493"}
        };
    }
}
