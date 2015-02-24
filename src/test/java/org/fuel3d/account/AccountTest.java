package org.fuel3d.account;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/AccountTest.json"},
        glue = {
                "org.fuel3d.util",
                "org.fuel3d.onlinelibrary.login",
                "org.fuel3d.onlinelibrary.account"
        },
        features = {
                "src/test/resources/feature/account/billing.feature"
        }
)
@RunWith(Cucumber.class)
public class AccountTest {
}