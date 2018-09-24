package com.shp.qa.testcases;

import com.shp.qa.base.TestBase;
import com.shp.qa.base.pages.HomePage;
import com.shp.qa.base.pages.LoginPage;
import com.shp.qa.base.pages.MyaccountPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest extends TestBase {
    //Initializing the Page Objects:
    //TestBase logging;
    HomePage homepage;
    MyaccountPage myaccountpage;
    LoginPage loginPage;

    public FirstTest() {super ();    }

    @BeforeMethod()
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
            }

    @Test(priority = 1)
    private void test1() {
         homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        myaccountpage = homepage.fittest();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
