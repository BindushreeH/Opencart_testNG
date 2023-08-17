package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "firstname")
    WebElement txtFirstName;
    @FindBy(id="input-lastname") WebElement txtLastName;
    @FindBy(name="email") WebElement txtEmail;
    @FindBy(name="telephone")WebElement txtTelephone;
    @FindBy(name="password")WebElement txtPassword;
    @FindBy(name="confirm")WebElement txtConfirmPwd;
    @FindBy(name="agree")WebElement chkAgree;
    @FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;

    public void setTxtFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void setTxtLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }
    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtTelephone(String telephone){
        txtTelephone.sendKeys(telephone);
    }
    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void setTxtConfirmPwd(String confirmPwd){
        txtConfirmPwd.sendKeys(confirmPwd);
    }
    public void setChkAgree(){
        chkAgree.click();
    }
    public void setBtnContinue(){
        btnContinue.submit();
    }
    public  String ramdomString(){
        String random_str= RandomStringUtils.randomAlphabetic(5);
        return random_str;
    }
    public void randomNumeric(){
        String ramdom_num=RandomStringUtils.randomNumeric(5);
        System.out.println(ramdom_num);
    }
    public String randomAlphaNumeric() {
        String random_alpha = RandomStringUtils.randomAlphabetic(6);
        String random_numeric = RandomStringUtils.randomNumeric(6);
        String alpha_numeric = random_alpha + "@" + random_numeric;
        return alpha_numeric;
    }
}
