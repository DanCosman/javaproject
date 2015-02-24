package org.fuel3d.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/LoginTest.json"},
        glue = {
                "org.fuel3d.util",
                "org.fuel3d.onlinelibrary.login"
        },
        features = {
                "src/test/resources/feature/login/login.feature"
        }
)
@RunWith(Cucumber.class)
public class LoginTest {
}