package org.fasttrackit.onlinelibrary.checkout;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/CheckoutTest.json"},
        glue = {
                "org.fasttrackit.util",
                "org.fasttrackit.onlinelibrary.checkout"
        },
        features = {
                "src/test/resources/feature/login/checkout.feature"
        }
)
@RunWith(Cucumber.class)
public class CheckoutTest {
}