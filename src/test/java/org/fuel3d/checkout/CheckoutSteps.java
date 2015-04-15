package org.fuel3d.checkout;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fuel3d.util.TestBase;
import org.fuel3d.view.CheckoutView;
import org.fuel3d.view.TopMenuNavigationView;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutSteps.class);

    private TopMenuNavigationView topMenuNavigation = new TopMenuNavigationView();
    private CheckoutView checkoutView = new CheckoutView();

    @When("^I place an order with valid details \"([^\"]*)\"$")
    public void I_place_an_order_with_valid_details(int option) throws Throwable {
        checkoutView.populatePage(option);
    }

    @And("^I click on div with xpath")
    public void I_click_on_div_with_xpath() throws Throwable {
        driver.findElement(By.xpath("//div[@id='billing_state_chosen']/div/ul/li[5]")).click();
        driver.findElement(By.cssSelector("#billing_state_chosen > div.chosen-drop > div.chosen-search > input[type=\"text\"]")).clear();
        driver.findElement(By.cssSelector("#billing_state_chosen > div.chosen-drop > div.chosen-search > input[type=\"text\"]")).sendKeys("alabama");
        throw new PendingException();
    }
}
