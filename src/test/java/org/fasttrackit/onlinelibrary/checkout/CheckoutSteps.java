package org.fasttrackit.onlinelibrary.checkout;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.fasttrackit.onlinelibrary.view.CheckoutView;
import org.fasttrackit.onlinelibrary.view.TopMenuNavigationView;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutSteps.class);
    
    private TopMenuNavigationView topMenuNavigation = new TopMenuNavigationView();
    private CheckoutView checkoutView = new CheckoutView();

    @When("^I place the order with valid details$")
    public void I_place_the_order_with_valid_details() throws Throwable {
        LOGGER.info("ajunge aici0");
        checkoutView.populatePage();
        checkoutView.placeOrder();
        throw new PendingException();
    }
}
