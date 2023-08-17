package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators
    @FindBy(xpath="//span[text()='My Account']")
    WebElement lnkMyAccount;
    @FindBy(xpath="//a[text()='Register']") WebElement lnkRegister;
    @FindBy(xpath="//a[text()='Login']")WebElement lnkLogin;

 public void clkMyAccount(){
    lnkMyAccount.click();
}
public void clkRegister(){
     lnkRegister.click();
 }
 public  void clkLogin(){
     lnkLogin.click();
 }
}


