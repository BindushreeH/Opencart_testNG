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
import utilities.DataProviders;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TC003_DataDrivenTest {
   public  WebDriver driver;
    Properties p;
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
        @BeforeClass(groups = {"data driven","master"})
      //  @Parameters("browser")
        void start() throws IOException {
            //void start() throws IOException {
              setup();
           // WebDriverManager.chromedriver().setup();
            FileReader file=new FileReader(System.getProperty("user.dir") + "//src/test/resources/config.properties");
            p=new Properties();
            p.load(file);
            driver.get(p.getProperty("url"));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(19));
        }
        @AfterClass(groups = {"data driven","master"})
        void tearDown(){
            driver.close();
        }
        @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"data driven","master"})
        void testDataDriven(String email,String password,String exp){
            try {
                HomePage hp = new HomePage(driver);
                hp.clkMyAccount();
                hp.clkLogin();
                LoginPage lp = new LoginPage(driver);
                lp.setTxtEmail(email);
                lp.setTxtPassword(password);
                lp.clkBtn();
                MyAccountPage mp = new MyAccountPage(driver);
                boolean targetPage = mp.getHeaderMsg();
                if(exp.equals("Valid")){
                    if(targetPage==true) {
                        mp.clkLogout();
                        Assert.assertTrue(true);
                    }
                        else{
                            Assert.assertTrue(false);
                        }
                }
                if(exp.equals("Invalid")){
                    if(targetPage==false){
                        System.out.println("test passed");
                        Assert.assertTrue(true);
                    }else {
                        mp.clkLogout();
                        System.out.println("test failed");
                        Assert.assertTrue(false);
                    }


                }

            }
            catch (Exception e){
                Assert.fail();
            }

        }

    }


