package runner2;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features2",glue= {"stepdefs"},
				monochrome = true,
				strict = true,
				format={"pretty","html:test-outout"},
				dryRun = false
				)


public class runner2 {

	public runner2() {
		// TODO Auto-generated constructor stub
	}

}
