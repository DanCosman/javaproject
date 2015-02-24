package org.fuel3d.util;

import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowUtilitySteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlowUtilitySteps.class);

    @Given("^I wait (\\d+) seconds$")
    public void wait_seconds(int seconds) {
        LOGGER.info("Waiting {} seconds", seconds);
        Utils.sleep(seconds * 1000);
    }

    @When("^I open url \"([^\"]*)\"$")
    public void I_open_LC_path(String url) throws Throwable {
        AppUtils.openUrl(url);
    }

    @Given("^I set browser size to (\\d+), (\\d+)$")
    public void setBrowserSize(int width, int height) throws Throwable {
        LOGGER.info("I set browser size to ({}, {})", width, height);
        WebDriverConfig.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Given("^I maximize browser$")
    public void maximizeBrowser() throws Throwable {
        WebDriverConfig.getDriver().manage().window().maximize();
    }
}
