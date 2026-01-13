package soap;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.model.testsuite.TestRunner.Status;


public class testingrunner {
@Test
	public  void SoapUITest(){
		
		//Grab the project test suite and the project 
		WsdlProject project=new WsdlProject("C:\\Users\\Acer\\OneDrive\\Desktop\\JavaAutomation-readyapi-project.xml");
		WsdlTestSuite testsuite=project.getTestSuiteByName("Test Suite2");
		for(int i=0;i<testsuite.getTestCaseCount();i++)
		{
			WsdlTestCase testcase=testsuite.getTestCaseAt(i);
			
			TestRunner runner=testcase.run(new PropertiesMap(),false);
			
			System.out.println("TestCase: " + testcase.getName());
            System.out.println("Runner status: " + runner.getStatus());
           
                testcase.getTestStepList().forEach(step->{
                	if(step instanceof WsdlTestRequestStep)
                	{
                		WsdlTestRequestStep reqStep= (WsdlTestRequestStep)step;
                		Response resp=reqStep.getTestRequest().getResponse();
                		if(resp!=null)
                		{
                			System.out.println("Step:"+ reqStep.getTestStep());
                            System.out.println("HTTP Status = " + resp.getContentType());
                           // System.out.println("Response length = " + resp.getContentAsString().length());


                			
                		}
                		else {
                            System.out.println("Step: " + reqStep.getName() + " -> NO RESPONSE OBJECT");
                        }
                    }
                		
                	}
                	);
                
                if (runner.getStatus() == com.eviware.soapui.model.testsuite.TestRunner.Status.FAILED) {
                    System.out.println("---- Errors ----");
                    AssertJUnit.assertEquals(Status.FINISHED, runner.getStatus());
              
                    };
                	
		
	}

		
}
}
