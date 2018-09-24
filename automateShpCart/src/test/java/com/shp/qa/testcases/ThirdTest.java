package com.shp.qa.testcases;

import com.shp.qa.base.TestBase;
import com.shp.qa.base.pages.AssertPage;
import com.shp.qa.base.pages.HomePage;
import com.shp.qa.base.pages.LoginPage;
import com.shp.qa.util.TestUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import java.io.File;

public class ThirdTest extends TestBase {
    AssertPage assertPage;
    LoginPage loginPage;
    TestUtil testUtil;
    HomePage homepage;
    public ThirdTest() {super ();    }


    @BeforeMethod()
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        assertPage = new AssertPage();
    }

    @Test(priority = 3)
    private void test2() {
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        assertPage =assertPage.snapshot();

    }
    @AfterMethod()
    public static void takeScreenshotAtEndOfTest() throws IOException
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
        driver.quit();
    }

}
