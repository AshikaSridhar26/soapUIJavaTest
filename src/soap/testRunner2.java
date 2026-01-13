package soap;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;

public class testRunner2 {

@Test	
	public void SingleTest()
	{
		WsdlProject project=new WsdlProject("C:\\Users\\Acer\\OneDrive\\Desktop\\JavaAutomation-readyapi-project.xml");
		WsdlTestSuite testsuite=project.getTestSuiteByName("Test Suite2");
		WsdlTestCase testcase=testsuite.getTestCaseByName("addEmploy");
		TestRunner runner=testcase.run(new PropertiesMap(),false);
		
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
        		
	});
}
}
