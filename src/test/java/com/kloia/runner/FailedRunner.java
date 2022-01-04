package com.kloia.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue = "com/kloia/stepDefs",
        plugin = {"pretty"}
)
public class FailedRunner {
}
