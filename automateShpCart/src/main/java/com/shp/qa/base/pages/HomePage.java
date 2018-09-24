package com.shp.qa.base.pages;

import com.shp.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

public class HomePage extends TestBase {

    //Page Factory - OR:
    //click women
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement womenDress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]/span")
    WebElement quickView;
    //item price
    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    WebElement itemP1;
    //add to cart
    @FindBy(name = "Submit")
    WebElement addToCart;

    @FindBy(name = "group_1")
    WebElement authorityDropDown;
    //continue cart
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
    WebElement continueCart;
    //quickview different item
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[2]/span")
    WebElement newQuickView;
    //item price
    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    WebElement itemP2;
    //total shipping
    @FindBy(xpath = "//*[@id=\"total_shipping\"]")
    WebElement totalShip;
    //total product
    @FindBy(xpath = "//*[@id=\"total_product\"]")
    WebElement totalProd;
    //total
    @FindBy(xpath = "//*[@id=\"total_price\"]")
    WebElement totalAmt;
    //add the item to cart
    @FindBy(name = "Submit")
    WebElement addaDress;
    //proceed to check out
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement proCheckOut;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement proCheckOut1;
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElement proCheckOut2;
    @FindBy(name = "cgv")
    WebElement CheckBox;
    @FindBy(name = "processCarrier")
    WebElement proCheckOut3;
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement BankWire;
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement ConfirmOrder;
    @FindBy(xpath="//div[@class='layer_cart_product_info']/span[@id=\"layer_cart_product_attributes\"]")
    WebElement sZ1;
    @FindBy(xpath="//span/span")
    WebElement sZ2;
    @FindBy(xpath = "//*[@id=\"product_1_5_0_98987\"]/td[2]/small[2]/a")
    WebElement sZ3;
    @FindBy(xpath = "//*[@id=\"product_2_7_0_98987\"]/td[2]/small[2]")
    WebElement sZ4;
    //signout
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOut;

    //Initialising the OR
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public MyaccountPage fittest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", signInBtn);
        js.executeScript("arguments[0].click();", womenDress);
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("arguments[0].click();", quickView);
        Select drop = new Select(authorityDropDown);
        drop.selectByIndex(2);

        String Price1 = (itemP1.getText()).replace("$", "");
        BigDecimal itPrice1 = new BigDecimal(Price1);
        System.out.println("Price of item-1="+itPrice1);

        js.executeScript("arguments[0].click();", addToCart);
        js.executeScript("arguments[0].click();", sZ1);
        String itemS1 = sZ1.getText();
        System.out.println("SIZE1="+ itemS1);

        js.executeScript("arguments[0].click();", continueCart);


        js.executeScript("arguments[0].click();", womenDress);
        js.executeScript("arguments[0].click();", newQuickView);

        String Price2 = (itemP2.getText()).replace("$", "");
        BigDecimal itPrice2 = new BigDecimal(Price2);
        System.out.println("Price of Item2="+ itPrice2);

        js.executeScript("arguments[0].click();", addaDress);

        js.executeScript("arguments[0].click();", sZ2);
        String itemS2 = sZ2.getText();
        System.out.println("SIZE2="+ itemS2);
        js.executeScript("arguments[0].click();", proCheckOut);

        js.executeScript("window.scrollBy(0,300)");
        String itemS3 = (sZ3.getText()).replaceAll("Color","").replaceAll("Size","").replaceAll(":","").replaceAll(" ","");
        System.out.println("SIZE3="+itemS3);
        String itemS4 = (sZ4.getText()).replaceAll("Color","").replaceAll("Size","").replaceAll(":","").replaceAll(" ","");
        System.out.println("SIZE3="+itemS4);
        if (itemS1 == itemS3 & itemS2 == itemS4) {
            System.out.println("*******SIZES ARE INCORRECT *********" + itemS1.length() + "oncheckout1:" + itemS3.length());
        } else {
            System.out.println("*******SIZE AND TOTAL AMOUNT ARE CORRECT *********");
        }
        BigDecimal toPro = itPrice1.add(itPrice2);
        System.out.println("Price of Item1+Item2="+toPro);
        String fPT1 = (totalProd.getText()).replace("$", "");
        BigDecimal finalProTotal = new BigDecimal(fPT1);
        System.out.println(finalProTotal);

        String shping = (totalShip.getText()).replace("$", "");
        BigDecimal shiPPing = new BigDecimal(shping);
        BigDecimal priTo = shiPPing.add(finalProTotal);
        System.out.println("***The Final Amount with Math is=" + priTo);
        BigDecimal fullTotal = new BigDecimal((totalAmt.getText()).replace("$", ""));
        System.out.println("The Total amount by shop is=" + fullTotal);
        if (fullTotal.equals(priTo)) {
            System.out.println("******THE TOTAL AMOUNT TALLIES *******");
            js.executeScript("arguments[0].click();", proCheckOut1);
            js.executeScript("arguments[0].click();", proCheckOut2);
            js.executeScript("arguments[0].click();", CheckBox);
            js.executeScript("arguments[0].click();", proCheckOut3);
            js.executeScript("window.scrollBy(0,500)");
            js.executeScript("arguments[0].click();", BankWire);
            js.executeScript("window.scrollBy(0,500)");
            js.executeScript("arguments[0].click();", ConfirmOrder);
            js.executeScript("window.scrollBy(0,500)");
            js.executeScript("arguments[0].click();", signOut);
            return new MyaccountPage();
        } else
            {
            System.out.println("*****THE TOTAL AMOUNT WITH SHIPPING IS SHOWING WRONG****************");
            return new MyaccountPage();
        }
    }
}
