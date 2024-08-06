package Pranavraj.AppiumFrameWorkDesign.PageObject.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.google.common.collect.ImmutableMap;

import Pranavraj.AppiumFrameDesign.utils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class formPage extends AndroidActions {
	
	AndroidDriver driver;
	public formPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	//driver.findElement(AppiumBy.id("android:id/text1")).click();
	private WebElement countrySelection;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Australia']")
	//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Australia']"))
	private WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("pranav")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	private WebElement shopButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	public void setCountry(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		selectCountry.click();
		
	}
	public void sendName(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void genderSelection(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}

	public void startActivity() {
		//code to type in cmd to know "adb shell dumpsys window | find "mCurrentFocus"
				//com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity}
		
		
			    ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
			            "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
	}
	public shoppingPage letsShop() {
		shopButton.click();
		return new shoppingPage(driver);
	}
}
