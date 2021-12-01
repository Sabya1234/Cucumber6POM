package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"@target/failedRerun.txt"},
		glue= {"parallel"},
		plugin= {"pretty",
				"rerun:target/failedRerun.txt"}
		)
public class FailRerunTest extends AbstractTestNGCucumberTests{
	
	
	@Override	
	@DataProvider
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	

}
