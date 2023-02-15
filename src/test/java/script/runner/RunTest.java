package script.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="features",glue= "glue.code",
	monochrome=true,
	dryRun = true,
	plugin= {
		"pretty","html:target/HTMLReports",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"
	},
	tags="@EtihadMultiCityBooking"
			)

public class RunTest {

}
