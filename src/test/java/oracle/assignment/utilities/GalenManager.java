package oracle.assignment.utilities;

import java.util.Arrays;

import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutObject;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.reports.model.LayoutSection;
import com.galenframework.reports.model.LayoutSpec;
import com.galenframework.reports.nodes.TestReportNode;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import oracle.assignmnet.driverFactory.DriverManager;

public class GalenManager extends DriverManager {
	
	public static void checkAndReportLayout(String gspecPath, String tagName, ExtentTest test)
	{
		try
		{
			
		  LayoutReport objLayoutReport = Galen.checkLayout(driver, gspecPath, Arrays.asList(tagName));
    
	      for(LayoutSection sections :objLayoutReport.getSections())
	      {
	    	  for(LayoutObject object :sections.getObjects())
	    	  {

	    		 for(LayoutSpec spec :object.getSpecs())
	    		 {
	    			
	    			 if(spec.getStatus().equals(TestReportNode.Status.ERROR))
	    			 {
	    				 for(String errorText : spec.getErrors())
	    			 		{
	    					 test.log(LogStatus.FAIL, "<B style=\"color:red\">"+object.getName()+"</B><br> "+errorText);
	    			 		}
	    				 
	    			 }
	    			 else
	    			 {
	    				 test.log(LogStatus.PASS, "<B style=\"color:blue\">"+object.getName()+"</B><br> "+spec.getName());
	    			 }
	    			 
	    		 }
	    	  }
	      }
	      
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
