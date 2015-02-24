package org.fuel3d.checkout;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/CheckoutTest.json"},
        glue = {
                "org.fuel3d.util",
                "org.fuel3d.onlinelibrary.checkout"
        },
        features = {
                "src/test/resources/feature/checkout/checkout.feature"
        }
)
@RunWith(Cucumber.class)
public class CheckoutTest {
}