package Pranavraj.AppiumFrameWorkDesign;




import org.testng.Assert;
import org.testng.annotations.Test;



import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.cartPage;

import Pranavraj.AppiumFrameWorkDesign.PageObject.Android.shoppingPage;
import Pranavraj.AppiumFrameWorkDesign.TestUtils.baseTest;


public class eCommerceWithoutPageObject extends baseTest {
	
	
	
	
	@Test
	public void ecommerce_Test3_switch_from_Apps_to_Webbrowser() throws InterruptedException {
		
		
		/*driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Australia']")).click();*/
		 
		formPage.setCountry("Australia");
		
		
		/*driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("pranav");
		driver.hideKeyboard();*/
		formPage.sendName("pranav");
		
		formPage.genderSelection("female");
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		shoppingPage shoppingPage=formPage.letsShop();
		
		
		/*driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
	
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"));"));
	driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();*/
		//shoppingPage shoppingPage=new shoppingPage(driver);
		shoppingPage.addProductsToCart("Converse All Star");
		cartPage cartPage=shoppingPage.cartPage();
		
		
	
	
	/*List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	int count=productPrices.size();
	double sum=0.0;
	for(int i=0;i<count;i++) {
		
		String amount=productPrices.get(i).getText();
		double price=formattedAmount(amount);
		sum=sum+price;
	}
	String displayAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	double displayformattedAmount=formattedAmount(displayAmount);*/
		double totalSum=cartPage.productList();
		double displayAmount=cartPage.getTotalAmountDisplayed();
	
		Assert.assertEquals(totalSum, displayAmount);

	
	/*WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	longPressAction(ele);*/
		
		cartPage.terms();
		
		//String displayText=driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		String displayText=cartPage.alertPopUp();
	
	Assert.assertEquals(displayText, "Terms Of Conditions");
	
	/*driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();*/
	cartPage.submittingPurchase();
	
	
	
	}
	
}
