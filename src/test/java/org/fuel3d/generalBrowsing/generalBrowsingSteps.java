package org.fuel3d.generalBrowsing;

import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.Given;
import org.fuel3d.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class generalBrowsingSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(generalBrowsingSteps.class);

    @Given("^I click on edit Billing Address$")
    public void I_click_on_edit_Billing_Address() throws Throwable {
        WebLink edit = new WebLink().setText("Edit").setLabel("Billing Address").setLabelTag("*");
        edit.assertClick();
    }

    @Given("^I click on edit Shipping Address$")
    public void I_click_on_edit_Shipping_Address() throws Throwable {
        WebLink edit = new WebLink().setText("Edit").setLabel("Shipping Address").setLabelTag("*");
        edit.assertClick();
    }
    
}
