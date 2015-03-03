package org.fuel3d.checkout;

import cucumber.api.java.en.When;
import org.fuel3d.util.TestBase;
import org.fuel3d.view.CheckoutView;
import org.fuel3d.view.TopMenuNavigationView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutSteps.class);

    private TopMenuNavigationView topMenuNavigation = new TopMenuNavigationView();
    private CheckoutView checkoutView = new CheckoutView();

    @When("^I place an order with valid details \"([^\"]*)\"$")
    public void I_place_an_order_with_valid_details(int option) throws Throwable {
        LOGGER.info("ajunge aici0");
        checkoutView.populatePage(option);
    }
}
