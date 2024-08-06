package Pranavraj.AppiumFrameWorkDesign.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportNG {

	static ExtentReports extent;
	public static ExtentReports getReportingObject() {
		
		String File=System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(File);
		
		reporter.config().setDocumentTitle("Test results");
		reporter.config().setReportName("Appium Results");
		reporter.config().setTheme(Theme.STANDARD);
		
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test runner", "Pranavraj");
		return extent;
	}
}
