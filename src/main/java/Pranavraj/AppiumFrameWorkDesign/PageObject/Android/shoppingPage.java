package Pranavraj.AppiumFrameWorkDesign.PageObject.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AppiumFrameDesign.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class shoppingPage extends AndroidActions {
	
	AndroidDriver driver;
	public shoppingPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}
		@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
		//driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
		private WebElement product1;
		
		@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")
		//driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		private WebElement product2;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		private WebElement cartPage;
	
	public void addProductsToCart(String Product2text) {
		product1.click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Converse All Star+"\"));"));
		scrollToText(Product2text);
		product2.click();
		
		
	}
	public cartPage cartPage() {
		cartPage.click();
		return new cartPage(driver);
	}

}
