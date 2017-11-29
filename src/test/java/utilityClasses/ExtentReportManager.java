package utilityClasses;

import com.relevantcodes.extentreports.ExtentReports;
import libraryClasses.*;

public class ExtentReportManager {
	
	static String userDir;
	 static ExtentReports report;
	 FuncitonLibrary libs = new FuncitonLibrary();
	
	public static ExtentReports invokeExtentReport(){
		FuncitonLibrary libs = new FuncitonLibrary();
		String Path = System.getProperty("user.dir")+"/Reports/"+FuncitonLibrary.applicationname+"/"+libs.datestamp()+"/"+FuncitonLibrary.applicationname+"_TestReport_"+libs.datestamp()+".html";
		System.out.println( "path html report : "+Path);
	    report = new ExtentReports(Path, false);
	    report
	    .addSystemInfo("Report Name", "TestReport")
	    .addSystemInfo("Report Type", "Automation Report");
//	    report.config().documentTitle("Sample ExtentReports report");
		return report;
	}


}
