package Pranavraj.AppiumFrameWorkDesign;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.cartPage;

import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.shoppingPage;
import Pranavraj.AppiumFrameWorkDesign.TestUtils.baseTest;
import io.appium.java_client.AppiumBy;


public class ErrorChecking extends baseTest {
	
	
	
	@BeforeMethod
	public void preSetUp() {
	
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent" ,"com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
			));
	}
	
	@Test
	public void FilForm_exceptional() throws InterruptedException {
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pranav");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please your name");
		
	}
	
	@Test
	public void FilForm_positive() {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pranav");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
	
	
	
	
	
}
