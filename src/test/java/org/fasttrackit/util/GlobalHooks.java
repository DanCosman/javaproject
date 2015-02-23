package org.fasttrackit.util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalHooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHooks.class);

    @Before
    public void beforeScenario(){
        EnvConfigurator.setEnviroment();
        InitWebDriver.driver = InitWebDriver.initWebDriver();
        LOGGER.info("Driver and configuration initialized");
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) InitWebDriver.driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } finally {
            InitWebDriver.driver.quit();
        }
    }
}
