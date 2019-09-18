package runner4;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="E://projectGherkin/Gherkins/ifiProfile/Feature4",glue= {"stepdefs2"},
				monochrome = true,
				strict = true,
				format={"pretty","html:test-outout"},
				dryRun = false
				)


public class runner4 {

	public runner4() {
		// TODO Auto-generated constructor stub
	}

}
