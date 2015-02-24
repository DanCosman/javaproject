package org.fuel3d.generalBrowsing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/generalBrowsingTest.json"},
        glue = {
                "org.fuel3d.util",
                "org.fuel3d.login",
                "org.fuel3d.account"
        },
        features = {
                "src/test/resources/feature/generalBrowsing/generalBrowsing.feature"
        }
)
@RunWith(Cucumber.class)
public class generalBrowsingTest {
}