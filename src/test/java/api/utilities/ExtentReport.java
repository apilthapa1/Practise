package api.utilities;

import java.io.File;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	//Project common data. System variables for the report
	static ExtentReports extentReport;
	static Properties configPropertyFile;
	public static ExtentReports generateExtentReport() {
		extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "/reports/apiReport.html");
		
		//Responsible for UI of report 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setDocumentTitle("API Report");
		
		extentReport.attachReporter(sparkReporter);
		
		setSystemInformation("Username", System.getProperty("user.name"));
		setSystemInformation("Java Version", System.getProperty("java.version"));
		setSystemInformation("Operating system", System.getProperty("os.name"));
		
		return extentReport;
	}
	
	private static void setSystemInformation(String key, String value) {
		extentReport.setSystemInfo(key, value);
	} 
}
