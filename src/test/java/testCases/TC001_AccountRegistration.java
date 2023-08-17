package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import pageObjects.SuccessPage;
import testBase.BaseTestCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class TC001_AccountRegistration extends BaseTestCase {
   public  WebDriver driver;
    Logger logger;
    ResourceBundle rb;
    FileReader file;
   void setup() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeClass(groups ={"master"})
    void start(){
        setup();
        logger= LogManager.getLogger(this.getClass());
         rb=ResourceBundle.getBundle("config");
       // file=new FileReader();
       // Properties p =new properties();
      //  p.load();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(rb.getString("url"));
    }
    @Test(groups = {"master"})
    void test_account(){
       try{
        logger.info("testAccontsLogin begins");
        HomePage hp=new HomePage(driver);
        hp.clkMyAccount();
        hp.clkRegister();
        logger.info("TAL ends");
            logger.info("Registration starts");
            RegistrationPage rp = new RegistrationPage(driver);
            rp.setTxtFirstName(ramdomString());
            rp.setTxtLastName(ramdomString());
            rp.setTxtEmail(ramdomString() + "@gmail.com");
            rp.setTxtTelephone(randomNumeric());
            String password = randomAlphaNumeric();
            rp.setTxtPassword(password);
            rp.setTxtConfirmPwd(password);
            rp.setChkAgree();
            rp.setBtnContinue();
            SuccessPage sp = new SuccessPage(driver);
            String msg = sp.getSuccessMsg();
            if (msg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            logger.info("Registration test passed");
       }else{
                logger.error("Registration failed");
                Assert.assertTrue(false);}

        }catch (Exception e){
            Assert.fail();

        }


    }
    @AfterClass(groups = {"master"})
    void tearDown(){
        driver.close();
    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination =".//screenshots//"+ tname + "_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }

}
