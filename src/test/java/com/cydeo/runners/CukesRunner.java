package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"html:target/cucumber-report.html",
                //"rerun:target/rerun.txt",
                //"me.jvt.cucumber.report.PrettyReports:target/cucumber",
                //"json:target/cucumber.json"
                "json:target/cucumber.json", //this one to connect with jira
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt"

        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@UPG10-297",
        publish = false
)


public class CukesRunner {
}
