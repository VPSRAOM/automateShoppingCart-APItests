package com.shp.qa.base.pages;

import com.shp.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{


    //Page Factory - OR:
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
     WebElement signInBtn;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement loginBtn;

   // @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    //WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement shpLogo;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    // public boolean validateCRMImage(){
    //    return crmLogo.isDisplayed();
    // }


    public HomePage login(String un, String pwd) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signInBtn);

        email.sendKeys(un);
        password.sendKeys(pwd);
        //loginBtn.click();
        js.executeScript("arguments[0].click();", loginBtn);

      return new HomePage();
    }
}





