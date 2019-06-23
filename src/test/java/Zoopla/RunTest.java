package Zoopla;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags = "@sale",format = {"pretty","html:target/cucumber-reports"})

public class RunTest {

}
