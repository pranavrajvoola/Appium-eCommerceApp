package Pranavraj.AppiumFrameDesign.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}


	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000));
		
	}
	
	public void scrollingAction(String direction) {
		Boolean canScrollMore;
		do {
		 canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
						"direction",direction,"percent",3.0));
		}while(canScrollMore);
	}
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	public void swipeAction(WebElement Ele,String direction) {
		
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)Ele).getId(),
						"direction",direction,
						"percent",0.1));
	}
	public void dragAction(WebElement Ele) {
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)Ele).getId(),
						"endX",619,
						"endY",521));
	}
	public double formattedAmount(String amount) {
		double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	
	
	

	

}
