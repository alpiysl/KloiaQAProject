package com.kloia.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty",
                "rerun:target/failed.txt"
                },
        features = "src/test/resources/features",
        glue = "com/kloia/stepDefs",
        dryRun = false
//        ,
//        tags = "@task4"
)
public class TestRunner {
}
