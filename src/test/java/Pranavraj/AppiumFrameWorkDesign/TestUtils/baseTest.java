package Pranavraj.AppiumFrameWorkDesign.TestUtils;

import org.testng.annotations.AfterClass; 
import org.testng.annotations.BeforeClass;
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import Pranavraj.AppiumFrameDesign.utils.appiumUtils;
import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.formPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class baseTest extends appiumUtils {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public formPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void configuration() throws URISyntaxException, IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Pranavraj\\AppiumFrameWorkDesign\\resources\\data.properties");
		

		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		prop.load(fis);
//		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service=startAppiumServer(ipAddress, Integer.parseInt(port));

		String appPath=System.getProperty("user.dir")+"\\src\\main\\java\\Pranavraj\\AppiumFrameWorkDesign\\resources\\ApiDemos-debug.apk";
		String appPath1=System.getProperty("user.dir")+"\\src\\main\\java\\Pranavraj\\AppiumFrameWorkDesign\\resources\\General-Store.apk";
		UiAutomator2Options option=new UiAutomator2Options();
		option.setDeviceName(prop.getProperty("AndroidDeviceName"));
		
		option.setApp(appPath1);
		
		
		driver= new AndroidDriver(service.getUrl(), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 formPage=new formPage(driver);
	}
	
	
	
	@AfterClass(alwaysRun=true)
	public void closing() throws InterruptedException {
		
		driver.quit();
		service.stop();
	}
	

}
