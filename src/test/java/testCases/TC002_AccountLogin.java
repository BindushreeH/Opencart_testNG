package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TC002_AccountLogin extends BaseTestCase {
   public static WebDriver driver;
    Properties p;
  // void setup(){//both approch are working
      //  WebDriverManager.chromedriver().setup();
     //   driver=new ChromeDriver();
   // }
    @BeforeClass(groups = {"master"})
    @Parameters("browser")
    void start(String br) throws IOException {
    //void start() throws IOException {
      //  setup();
        WebDriverManager.chromedriver().setup();
        if(br.equals("chrome")){
           driver=new ChromeDriver();
       }
        FileReader file=new FileReader(System.getProperty("user.dir") + "//src/test/resources/config.properties");
        p=new Properties();
        p.load(file);
        driver.get(p.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass(groups = {"master"})
    void tearDown(){
        driver.close();
    }
    @Test(groups = {"master"})
    void testAccountLogin(){
        try {
            HomePage hp = new HomePage(driver);
            hp.clkMyAccount();
            hp.clkLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setTxtEmail(p.getProperty("email"));
            lp.setTxtPassword(p.getProperty("password"));
            lp.clkBtn();
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetPage = mp.getHeaderMsg();
            Assert.assertEquals(targetPage, true);
        }
        catch (Exception e){
            Assert.fail();
        }

    }

}
