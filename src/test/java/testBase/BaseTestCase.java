package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestCase {
   public  WebDriver driver;


    public  String ramdomString(){
        String random_str= RandomStringUtils.randomAlphabetic(5);
        return random_str;
    }
    public String randomNumeric(){
        String ramdom_num=RandomStringUtils.randomNumeric(5);
        return ramdom_num;
    }
    public String randomAlphaNumeric(){
        String []a={"@"+"$"+"#"};
        String random_alpha=RandomStringUtils.randomAlphabetic(6);
        String random_numeric=RandomStringUtils.randomNumeric(6);
        String alpha_numeric=random_alpha+a+random_numeric;
        return alpha_numeric;
    }
   /* public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = ".//screenshots//" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }*/



}
