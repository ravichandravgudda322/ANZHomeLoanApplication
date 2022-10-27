package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class baseClass {

  public WebDriver driver;
  public Properties properties;


  public WebDriver initializeWebDriver() throws IOException {

    properties = new Properties();
    FileInputStream fis = new FileInputStream("/Users/ravi/Desktop/HomeLoanApplication/src/main/java/resources/data2.properties");

    properties.load(fis);
    String browserName = properties.getProperty("browser");
    System.out.println(browserName);

    System.setProperty("webdriver.chrome.driver", "/Users/ravi/Desktop/HomeLoanApplication/src/main/java/resources/chromedriver");
    driver = new ChromeDriver();


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;


  }


}
