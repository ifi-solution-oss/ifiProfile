package runner6;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Feature6",glue= {"stepdfs3"},
				monochrome = true,
				strict = true,
				format={"pretty","html:test-outout"},
				dryRun = false
				)


public class Runner6 {

	public Runner6() {
		// TODO Auto-generated constructor stub
	}

}
