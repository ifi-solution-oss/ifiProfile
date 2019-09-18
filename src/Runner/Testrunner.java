package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="E://projectGherkin/Gherkins/ifiProfile/Features",glue= {"stepdefinitions"},
				monochrome = true,
				strict = true,
				format={"pretty","html:test-outout"},
				dryRun = false
				//plugin = "pretty"
				)



public class Testrunner {

	public Testrunner() {
		// TODO Auto-generated constructor stub
	}

}
