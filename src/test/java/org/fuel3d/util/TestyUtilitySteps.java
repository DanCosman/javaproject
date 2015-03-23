package org.fuel3d.util;

import com.sdl.bootstrap.button.Button;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.SimpleTextField;
import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestyUtilitySteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestyUtilitySteps.class);
    public SimpleTextField numGuess = new SimpleTextField().setId("number");
    private SimpleTextField numberField = new SimpleTextField().setLabel("Number: ", SearchType.STARTS_WITH);
    //private SimpleTextField numberField = new SimpleTextField().setId("number");
    private InputButton guessNowButton = new InputButton().setText("Guess now");
    private WebLocator wrongNumberElement = new WebLocator().setText("WRONG, Try a !", SearchType.STARTS_WITH);

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) {
        WebLink link = new WebLink().setText(text);
        link.assertClick();
    }

    @When("^I mouse over on element with text \"([^\"]*)\"$")
        public void I_mouse_over_on_element_with_text(String text) {
                WebLocator element = new WebLocator().setText(text);
        element.mouseOver();
            }

    @Then("^I should be on url \"([^\"]*)\"$")
        public void I_should_be_on_url(String url) {
                assertThat(WebDriverConfig.getDriver().getCurrentUrl(), is(url));
            }

    @When("^I focus a link with text \"([^\"]*)\"$")
    public void I_focus_a_link_with_text(String text)
    {
        WebLink link = new WebLink().setText(text);
        link.focus();
    }

    @When("^I click on input button with text \"([^\"]*)\"$")
    public void I_click_on_input_button_with_text(String text) throws Throwable {
        InputButton button = new InputButton().setText(text);
        button.assertClick();
    }

    @When("^I click on button with text \"([^\"]*)\"$")
    public void I_click_on_button_with_text(String text) throws Throwable {
        Button button = new Button().setText(text);
        button.assertClick();
    }

    @Then("^I should see an element with text \"([^\"]*)\"$")
    public void assertHaveElementWithText(String text) throws Throwable {
        WebLocator element = new WebLocator().setText(text);
        assertThatElementIsReady(element);
    }

    @Then("^I should see following elements with texts \"(.*)\"$")
    public void assertHaveElementsWithText(List<String> texts) throws Throwable {
        for (String text : texts) {
            assertHaveElementWithText(text);
        }
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void typeIntoField(String value, String label) throws Throwable {
        SimpleTextField field = new SimpleTextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        field.setValue(value);
    }

    public static void main(String[] args) {
        SimpleTextField field = new SimpleTextField().setLabel("Password", SearchType.DEEP_CHILD_NODE_OR_SELF);

        WebLocator header = new WebLocator().setTag("header");

        WebLink link = new WebLink().setContainer(header).setText("Log In");
        WebLink cart = new WebLink().setContainer(header).setText("Cart");

        LOGGER.debug(link.getPath());
    }

    @Then("^text field with label \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_label_should_have_value(String label, String value) throws Throwable {
        SimpleTextField field = new SimpleTextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        assertThat(field.getValue(), is(value));
    }

    @And("^I type \"([^\"]*)\" into field with id \"([^\"]*)\"$")
    public void I_type_into_field_with_id(String value, String id) {
        SimpleTextField field = new SimpleTextField().setId(id);
        field.setValue(value);
    }

    @And("^I type into field the value \"([^\"]*)\"")
    public void I_type_into_field_the_value(String value) {
        numGuess.sendKeys(value);
    }

    @When("^I enter number (\\d+)$")
    public void I_enter_number(int arg1) throws Throwable {
        numberField.setValue(arg1 + "");
    }

    @Then("^I enter number until I guess$")
    public void I_enter_number_until_I_guess() throws Throwable {
        for (int i = 1; i <= 10; i++) {
            numberField.setValue(i + "");
            guessNowButton.assertClick();
            String text = "Congrats, you guessed the number " + i + " after " + i + " guesses.";
            WebLocator guessedNumberElement = new WebLocator().setText(text);
            if(guessedNumberElement.ready()) {
                LOGGER.info("element found: " + text);
                break;
            }
        }
    }

    @When("^I move to an element with text \"([^\"]*)\" and click on subMenu \"([^\"]*)\"$")
    public void I_mouse_over_on_element_with_link(String text, String text2) {
        WebLocator link = new WebLocator().setText(text);
        link.ready();
        Actions builder = new Actions(driver);
        builder.moveToElement(link.currentElement).perform();
        WebLocator subMenu = new WebLocator().setText(text2);
        subMenu.click();
    }
}

