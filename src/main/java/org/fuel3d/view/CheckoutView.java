package org.fuel3d.view;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.SimpleTextField;
import org.apache.commons.lang3.RandomStringUtils;
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
    public SimpleTextField selectDirectBank = new SimpleTextField(this).setId("payment_method_bacs");
    public SimpleTextField selectStripeCard = new SimpleTextField(this).setId("payment_method_stripe");
    public SimpleTextField cardNumberField = new SimpleTextField(this).setId("stripe-card-number");
    public SimpleTextField cardExpiryField = new SimpleTextField(this).setId("stripe-card-expiry");
    public SimpleTextField cvcField = new SimpleTextField(this).setId("stripe-card-cvc");
    public SimpleTextField termsCheckbox = new SimpleTextField(this).setId("terms");


    public void populatePage(int option) throws Throwable {
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
        selectDirectBank.click();
        Thread.sleep(1000);
        selectStripeCard.click();
        Thread.sleep(2000);
        cardNumberField.sendKeys(cardNumber);
        if (!cardNumberField.getAttribute("value").equals(cardNumber))
            cardNumberField.sendKeys(cardNumber);
        cardExpiryField.sendKeys("12/2018");
        cvcField.sendKeys("123");
        termsCheckbox.click();


        switch (option)
        {
            case 0:
                firstNameField.clear();
                break;
            case 1:
                firstNameField.clear();
                break;
            case 2:
                lastNameField.clear();
                break;
            case 3:
                addressField.clear();
                break;
            case 4:
                cityField.clear();
                break;
            case 5:
                //requires US & Canada Store
                break;
            case 6:
                postcodeField.clear();
                break;
            case 7:
                postcodeField.clear();
                postcodeField.sendKeys("1010");
                break;
            case 8:
                //select Spain from country dropdown
                break;
            case 9:
                emailField.clear();
                break;
            case 10:
                emailField.clear();
                emailField.sendKeys("ab.ab");
                break;
            case 11:
                phoneField.clear();
                break;
            case 12:
                phoneField.clear();
                phoneField.sendKeys("!@#");
                break;
            case 13:
                accountPassword.clear();
                break;
            case 14:
                termsCheckbox.click();
                break;
            case 15:
                cardNumberField.clear();
                if (cardNumberField.getAttribute("value").equals(cardNumber))
                cardNumberField.sendKeys(cardNumber);
                cardExpiryField.clear();
                cvcField.clear();
                break;
            case 16:
                cardNumberField.clear();;
                break;
            case 17:
                cardNumberField.clear();;
                cardNumberField.sendKeys("123");
                break;
            case 18:
                cardExpiryField.clear();
                break;
            case 19:
                cardExpiryField.clear();
                cardExpiryField.sendKeys("12/2009");
                break;
            case 20:
                cvcField.clear();
                break;

            default:
                break;
        }

    }

//        public void placeOrder() {
//            if (!termsCheckbox.isSelected())
//                termsCheckbox.click();
//                orderButton.click();
//            }

}