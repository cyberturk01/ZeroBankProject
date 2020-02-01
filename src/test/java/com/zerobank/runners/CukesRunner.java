package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        //where our feature files are located.
        features = "src/test/resources/features/",
        glue = "com/zerobank/step_definitions/",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
