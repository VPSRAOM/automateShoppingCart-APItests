package com.shp.qa.base.pages;

import com.shp.qa.base.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import junit.framework.Assert;

public class MyaccountPage extends TestBase {

    //afterlogin
//click my orders
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
    WebElement myOrder;
    //click on order reference
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr/td[1]/a")
    WebElement orRef;
    //assert confirm by date
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")
    @CacheLookup
    WebElement assDate;
    //  ("09/15/2018",")).getText());
    @FindBy(xpath = "//*[@id=\"order-list\"]/thead/tr/th[2]/span")
    WebElement sortDate;

    //adding message...selecting item from drop down
    @FindBy(xpath = "//*[@id=\"sendOrderMessage\"]/p[2]/select")
    WebElement dropDown;
    // add a message
    @FindBy(xpath = "//*[@id=\"sendOrderMessage\"]/p[3]/textarea")
    WebElement typeMsg;
    // click to send
    @FindBy(name = "submitMessage")
                WebElement addMsg;
    //confirm comment appears under messages
    @FindBy(xpath="//tr[contains(@class,'alternate_item')]")
        WebElement assCmt;
    //signout
    @FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOut;
    // assertEquals("I will collect the order",")).getText());
    public boolean verifyTheDate()  {
        return assDate.isDisplayed();
    }
       public MyaccountPage() {
        PageFactory.initElements(driver, this);
    }
    public AssertPage saltest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", myOrder);
        js.executeScript("window.scrollBy(0,300)");
        js.executeScript("arguments[0].click();", sortDate);
           String bla=assDate.getText();
        Assert.assertEquals("09/15/2018",bla );
                js.executeScript("arguments[0].click();", orRef);
                Select drop = new Select(dropDown);
                drop.selectByIndex(2);
                typeMsg.sendKeys("I will collect the order");
                 js.executeScript("arguments[0].click();", addMsg);
                String M=assCmt.getText();

        if (M!="")
    {
           System.out.print("**********Found My message *********");
        }
        js.executeScript("arguments[0].click();", signOut);
            return new AssertPage();
    }
}
