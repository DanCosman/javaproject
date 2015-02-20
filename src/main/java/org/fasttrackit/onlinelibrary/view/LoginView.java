package org.fasttrackit.onlinelibrary.view;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.SimpleTextField;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView extends WebLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    public LoginView() {
        setClasses("login");
    }

    public SimpleTextField userNameField1 = new SimpleTextField(this).setLabel("Username or email address", SearchType.DEEP_CHILD_NODE_OR_SELF)
            .setLabelPosition("//following-sibling::");
    public SimpleTextField userNameField = new SimpleTextField(this).setName("username");
    public SimpleTextField passwordField = new SimpleTextField(this).setName("password");

    public SimpleTextField fakePasswordField = new SimpleTextField(this).setLabel("Password", SearchType.CHILD_NODE)
            .setLabelPosition("//following-sibling::").setPosition(2);

    public InputButton loginButton = new InputButton(this, "Login");

    public WebLocator invalidUserErrorElement = new WebLocator().setText("Invalid username");
    public WebLocator userNotFoundErrorElement = new WebLocator().setText("A user could not be found with this email address.");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        fakePasswordField.click(); // this is how ui is implemented
        passwordField.setValue(pass);
        loginButton.assertClick();
    }

        @FindBy(id = "billing_first_name")
        public WebElement firstNameField;

        @FindBy(id = "billing_last_name")
        public WebElement lastNameField;

        @FindBy(id = "billing_address_1")
        public WebElement addressField;

        @FindBy(id = "billing_city")
        public WebElement cityField;

        @FindBy(id = "billing_postcode")
        public WebElement postcodeField;

        @FindBy(id = "billing_email")
        public WebElement emailField;

        @FindBy(id = "billing_phone")
        public WebElement phoneField;

        @FindBy(id = "account_password")
        public WebElement accountPassword;

        @FindBy(id = "stripe-card-number")
        public WebElement cardNumberField;

        @FindBy(id = "stripe-card-expiry")
        public WebElement cardExpiryField;

        @FindBy(id = "stripe-card-cvc")
        public WebElement cvcField;

        @FindBy(id = "terms")
        public WebElement termsCheckbox;

        @FindBy(id = "place_order")
        public WebElement orderButton;

        public void populatePage() throws InterruptedException {
            firstNameField.sendKeys(RandomStringUtils.randomAlphabetic(6));
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
        }

        public void placeOrder() {
            if (!termsCheckbox.isSelected())
                termsCheckbox.click();
            orderButton.click();
        }


    public static void main(String[] args) {
        LOGGER.debug(new LoginView().loginButton.getPath());
    }
}
