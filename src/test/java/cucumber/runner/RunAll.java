package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"
        },
        features = {"src/test/java/cucumber/features"},
        glue = {"cucumber.stepDef"}// give the directory of stepDefinition

)
public class RunAll {
}
