package Pranavraj.AppiumFrameWorkDesign;




import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Pranavraj.AppiumFrameDesign.utils.AndroidActions;
import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.cartPage;

import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.shoppingPage;
import Pranavraj.AppiumFrameWorkDesign.TestUtils.baseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class eCommerce_Hybrid extends baseTest {
	
	
	
	
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void ecommerce_Test3_switch_from_Apps_to_Webbrowser(String country,String name,String gender) throws InterruptedException {
		
		
		
		formPage.setCountry(country);
		formPage.sendName(name);
		formPage.genderSelection(gender);
		shoppingPage shoppingPage=formPage.letsShop();
		shoppingPage.addProductsToCart("Converse All Star");
		cartPage cartPage=shoppingPage.cartPage();
		cartPage.getTotalAmountDisplayed();
		cartPage.terms();
		cartPage.alertPopUp();
		cartPage.submittingPurchase();

		Thread.sleep(2000);
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts) {
			
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("voola pranavraj");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.longPressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");



		
	
	
	
}
	@BeforeMethod(alwaysRun=true)
	public void preStep() {
		formPage.startActivity();
	}
	
	@DataProvider
	public Object getData() {
		
		return new Object[][] {{"Australia","pranav","female"},{"Argentina","pranav","male"}};
		
	}
	
}
