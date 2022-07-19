package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.GENERICUTILITY.BaseClass;

public class SampleTest extends BaseClass {
	
	@Test(retryAnalyzer = com.vtiger.comcast.GENERICUTILITY.ReTry.class)
	public void amazonTest()
	{
		System.out.println("run success");
		Assert.assertEquals("A", "B");
		System.out.println("hiii");
	}

}
