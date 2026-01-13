package rest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;

public class TestREsTAPI {
	@Test
	public void RESTAPI() {
		
	WsdlProject project=new WsdlProject("C:\\Users\\Acer\\OneDrive\\Desktop\\MapsAPI-readyapi-project.xml");
	for(int j=0;j<project.getTestSuiteCount();j++)
	{
		WsdlTestSuite testsuite=project.getTestSuiteAt(j);
		for(int i=0;i<testsuite.getTestCaseCount();i++) {
			WsdlTestCase testcase=testsuite.getTestCaseAt(i);
		
				TestRunner runner=testcase.run(new PropertiesMap(),false);
				 

				System.out.println("TestCase: " + testcase.getName());
	            System.out.println("Runner status: " + runner.getStatus());
	            AssertJUnit.assertEquals(Status.FINISHED, runner.getStatus());
	           for(int k=0;k<testcase.getTestStepCount();k++)
	           {
	        	   WsdlTestStep step=testcase.getTestStepAt(k); 
	        	   WsdlTestCaseRunner tcRunner = new WsdlTestCaseRunner(testcase, new PropertiesMap());
	                WsdlTestRunContext context = new WsdlTestRunContext(step);
	                step.run(tcRunner, context);
                    
	        	   System.out.println("TestStep: " + step.getName());
	        	  
		            System.out.println("Runner status: " + tcRunner.getStatus());
		            
	                
		           
	           }
		}
		 
	};
	 
	

}
}


