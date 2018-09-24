package com.shp.qa.base.pages;

import com.shp.qa.base.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssertPage extends TestBase {
    //click my orders
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
    WebElement myOrder;
    @FindBy(xpath = "//*[@id=\"order-list\"]/thead/tr/th[2]/span")
    WebElement sortDate;
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")
    @CacheLookup
    WebElement assDate;
    //signout
    @FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOut;



    public AssertPage() {
        PageFactory.initElements(driver, this);
    }

    public AssertPage snapshot() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", myOrder);
        js.executeScript("window.scrollBy(0,300)");
        js.executeScript("arguments[0].click();", sortDate);
        String fsnap = assDate.getText();
        Assert.assertEquals("09/19/2018", fsnap);
        js.executeScript("arguments[0].click();", signOut);
        return new AssertPage();
    }

}
