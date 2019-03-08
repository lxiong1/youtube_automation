package utility

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@CucumberOptions(features='src/test/groovy/features', glue='src/test/groovy/step_definitions')
@RunWith(Cucumber.class)

class CucumberRunner
{

}