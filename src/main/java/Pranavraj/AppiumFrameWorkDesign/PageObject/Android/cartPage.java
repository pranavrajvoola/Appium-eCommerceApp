package Pranavraj.AppiumFrameWorkDesign.PageObject.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AppiumFrameDesign.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartPage extends AndroidActions{
	
	AndroidDriver driver;
	public cartPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	//List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	private List<WebElement> productList;

	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	//String displayAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	private WebElement displayAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	//WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	private WebElement ele;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	//String displayText=driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
	private WebElement alertTitle;
	
	@AndroidFindBy(id="android:id/button1")
	//driver.findElement(By.id("android:id/button1")).click();
	private WebElement okButton;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	//driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")).click();
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	private WebElement completePurchaseButton;
	
	public double productList()  {
		int count=productList.size();
		double totalSum=0.0;
		for(int i=0;i<count;i++) {
			
			String amount=productList.get(i).getText();
			double price=formattedAmount(amount);
			totalSum=totalSum+price;
			
	}return totalSum;
		}
	public double getTotalAmountDisplayed() {
		
		return formattedAmount(displayAmount.getText());
	}
	
	public void terms() {
		longPressAction(ele);
	}
	public String alertPopUp() {
		String TitleMessage=alertTitle.getText();
		return TitleMessage;
	}
	public void submittingPurchase() {
		okButton.click();
		checkBox.click();
		completePurchaseButton.click();
	}

}
