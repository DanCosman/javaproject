package org.fuel3d.util;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestyUtilitySteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestyUtilitySteps.class);
    public TextField numGuess = new TextField().setId("number");
    private TextField numberField = new TextField().setLabel("Number: ", SearchType.STARTS_WITH);
    //private TextField numberField = new TextField().setId("number");
    private InputButton guessNowButton = new InputButton().setText("Guess now");
    private WebLocator wrongNumberElement = new WebLocator().setText("WRONG, Try a !", SearchType.STARTS_WITH);
    public TextField termsCheckbox = new TextField().setId("terms");

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) {
        WebLink link = new WebLink().setText(text);
        link.assertClick();
    }

    @And("^I click on link with css \"([^\"]*)\"$")
    public void I_click_on_link_with_css(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

    @When("^I click on link with deep text \"([^\"]*)\"$")
    public void I_click_on_link_with_deep_text(String text) {
        WebLink link = new WebLink().setText(text, SearchType.EQUALS, SearchType.DEEP_CHILD_NODE);
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

    @When("^I click on input button with name \"([^\"]*)\"$")
    public void I_click_on_input_button_with_name(String name) throws Throwable {
        InputButton button = new InputButton().setName(name);
        button.assertClick();
    }

    @When("^I click on button with text \"([^\"]*)\"$")
    public void I_click_on_button_with_text(String text) throws Throwable {
        Button button = new Button().setText(text);
        button.assertClick();
    }

    @When("^I click on button with id \"([^\"]*)\"$")
    public void I_click_on_button_with_id(String id) throws Throwable {
        Button button = new Button().setId(id);
        button.assertClick();
    }

    @When("^I click on terms checkbox")
    public void I_click_on_checkbox() throws Throwable {
        termsCheckbox.click();
    }

    @Then("^I should see an element with text \"([^\"]*)\"$")
    public void assertHaveElementWithText(String text) throws Throwable {
        WebLocator element = new WebLocator().setText(text);
//        assertThatElementIsReady(element);
        element.assertReady();
    }

    @Then("^text field with css \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_css_should_have_value(String css, String value) throws Throwable {
        TextField field = new TextField().setElCssSelector(css);
        assertThat(field.getValue(), is(value));
    }

    @Then("^text field with class \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_class_should_have_value(String clas, String value) throws Throwable {
        TextField field = new TextField().setClasses(clas);
        assertThat(field.getValue(), is(value));
    }

    @Then("^I should see following elements with texts \"(.*)\"$")
    public void assertHaveElementsWithText(List<String> texts) throws Throwable {
        for (String text : texts) {
            assertHaveElementWithText(text);
        }
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void typeIntoField(String value, String label) throws Throwable {
        TextField field = new TextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        field.setValue(value);
    }

    public static void main(String[] args) {
        TextField field = new TextField().setLabel("Password", SearchType.DEEP_CHILD_NODE_OR_SELF);

        WebLocator header = new WebLocator().setTag("header");

        WebLink link = new WebLink().setContainer(header).setText("Log In");
        WebLink cart = new WebLink().setContainer(header).setText("Cart");

        LOGGER.debug(link.getPath());
    }

    @Then("^text field with label \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_label_should_have_value(String label, String value) throws Throwable {
        TextField field = new TextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        assertThat(field.getValue(), is(value));
    }

    @And("^I type \"([^\"]*)\" into field with id \"([^\"]*)\"$")
    public void I_type_into_field_with_id(String value, String id) {
        TextField field = new TextField().setId(id);
        field.setValue(value);
    }

    @And("^I enter value \"([^\"]*)\" into field with id \"([^\"]*)\"$")
    public void I_enter_value_into_field_with_id(String value, String id) {
        TextField field = new TextField().setId(id);
        field.clear();
        field.setType(value);
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


    @And("^I select \"([^\"]*)\" from dropdown menu with name \"([^\"]*)\"$")
    public void I_select_from_dropdown_menu_with_name(String label, String name) {
        WebElement dropDownListBox = driver.findElement(By.name(name));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(label);
    }

    @And("^I select \"([^\"]*)\" from dropdown menu with id \"([^\"]*)\"$")
    public void I_select_from_dropdown_menu_with_id(String label, String id) {
        WebElement dropDownListBox = driver.findElement(By.id(id));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(label);
    }

    @And("^I type \"([^\"]*)\" on textarea with id \"([^\"]*)\"$")
    public void I_type_on_textarea_with_id(String value, String id) {
        WebElement textarea = driver.findElement(By.id(id));
        textarea.clear();
        textarea.sendKeys(value);
    }

    @And("^I type \"([^\"]*)\" on textarea with name \"([^\"]*)\"$")
    public void I_type_on_textarea_with_name(String value, String name) {
        WebElement textarea = driver.findElement(By.name(name));
        textarea.clear();
        textarea.sendKeys(value);
    }

    @And("^I type \"([^\"]*)\" into field with name \"([^\"]*)\"$")
    public void I_type(String value, String name) {
        TextField field = new TextField().setName(name
        );
        field.setValue(value);
    }

    @And("^I click on submit button with xpath \"([^\"]*)\"$")
    public void I_click_on_submit_button_with_xpath(String xpath) throws Throwable {
        driver.findElement(By.xpath(xpath)).click();
    }
}