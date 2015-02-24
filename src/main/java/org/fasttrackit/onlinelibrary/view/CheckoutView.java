package org.fasttrackit.onlinelibrary.view;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.SimpleTextField;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutView extends WebLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutView.class);

    public CheckoutView() {
        setClasses("checkout");
    }

    public SimpleTextField firstNameField = new SimpleTextField(this).setId("billing_first_name");
    public SimpleTextField lastNameField = new SimpleTextField(this).setId("billing_last_name");
    public SimpleTextField addressField = new SimpleTextField(this).setId("billing_address_1");
    public SimpleTextField cityField= new SimpleTextField(this).setId("billing_city");
    public SimpleTextField postcodeField = new SimpleTextField(this).setId("billing_postcode");
    public SimpleTextField emailField = new SimpleTextField(this).setId("billing_email");
    public SimpleTextField phoneField = new SimpleTextField(this).setId("billing_phone");
    public SimpleTextField accountPassword = new SimpleTextField(this).setId("account_password");
    public SimpleTextField cardNumberField = new SimpleTextField(this).setId("stripe-card-number");
    public SimpleTextField cardExpiryField = new SimpleTextField(this).setId("stripe-card-expiry");
    public SimpleTextField cvcField = new SimpleTextField(this).setId("stripe-card-cvc");
    public SimpleTextField termsCheckbox = new SimpleTextField(this).setId("terms");


        public void populatePage() throws Throwable {
            LOGGER.info("ajunge aici");
            firstNameField.setValue(RandomStringUtils.randomAlphabetic(6));
            lastNameField.sendKeys(RandomStringUtils.randomAlphabetic(6));
            addressField.sendKeys(RandomStringUtils.randomAlphabetic(10));
            cityField.sendKeys(RandomStringUtils.randomAlphabetic(10));
            postcodeField.sendKeys("HP11 2TY");
            emailField.sendKeys(RandomStringUtils.randomAlphabetic(5) + "@example.com");
            phoneField.sendKeys(RandomStringUtils.randomNumeric(8));
            accountPassword.sendKeys("password");
            String cardNumber = "4111111111111111";
            cardNumberField.sendKeys(cardNumber);
            if (!cardNumberField.getAttribute("value").equals(cardNumber))
                cardNumberField.sendKeys(cardNumber);
            cardExpiryField.sendKeys("12/2018");
            cvcField.sendKeys("123");
            termsCheckbox.click();
        }

//        public void placeOrder() {
//            if (!termsCheckbox.isSelected())
//                termsCheckbox.click();
//                orderButton.click();
//            }

}
