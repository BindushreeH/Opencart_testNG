package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage{
    public SuccessPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successMsg;
     public String getSuccessMsg(){
        try{
          return  successMsg.getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
