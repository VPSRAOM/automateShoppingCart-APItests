package com.shp.qa.testcases;

import com.shp.qa.base.TestBase;
import com.shp.qa.base.pages.AssertPage;
import com.shp.qa.base.pages.HomePage;
import com.shp.qa.base.pages.LoginPage;
import com.shp.qa.base.pages.MyaccountPage;
import com.shp.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest extends TestBase {

    MyaccountPage myaccountpage;
    LoginPage loginPage;
    AssertPage asrtP;
    TestUtil testUtil;
    HomePage homepage;
    public SecondTest() {super ();    }

    @BeforeMethod()
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        myaccountpage = new MyaccountPage();
         }

    @Test (priority = 2)
    private void test2() {
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        asrtP = myaccountpage.saltest();
    }

    @AfterMethod
    public void tearDown()
    {
         driver.quit();
    }
}
