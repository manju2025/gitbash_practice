package alterrio_retro_project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPracticeTest 
	{
	@Test(dependsOnMethods="script2test",alwaysRun=false)
	public void script1test()
	{
	System.out.println("script1");
	Assert.fail();
	}
	@Test
	public void script2test()
	{
		System.out.println("script2");	
		Assert.fail();
		
	}

}
