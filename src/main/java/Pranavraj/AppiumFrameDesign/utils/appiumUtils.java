package Pranavraj.AppiumFrameDesign.utils;

import java.io.File;  
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumUtils {
public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer(String iPAddress, int port) {
		
		String path= "\\Users\\HOME\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		service = new AppiumServiceBuilder().withAppiumJS(new File(path))
				.withIPAddress(iPAddress).usingPort(port).build();
		service.start();
		return service;
	}
	public String getScreenShot(String testcaseName,AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

}
