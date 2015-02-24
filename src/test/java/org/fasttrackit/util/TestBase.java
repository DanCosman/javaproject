package org.fasttrackit.util;

import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    protected boolean isLogged = false;
    private static boolean closeBrowserWhenFinish = true;

    public static void setCloseBrowserWhenFinish(boolean closeBrowserWhenFinish) {
        TestBase.closeBrowserWhenFinish = closeBrowserWhenFinish;
    }

    static {
        try {
            startSuite();
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }


    private static void startSuite() {
        try {
            //   driver = WebDriverConfig.getWebDriver(Browser.FIREFOX);

            EnvConfigurator.setEnviroment();
  //          InitWebDriver.driver = InitWebDriver.initWebDriver();
            driver = initWebDriver();
            WebDriverConfig.init(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(150, TimeUnit.MILLISECONDS);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    if (closeBrowserWhenFinish) {
                        initSeleniumEnd();

                    }
                }
            });
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }

    private static WebDriver initWebDriver() {
        if (EnvConfigurator.browser().equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(true);
            profile.setPreference("webdriver.load.strategy", "unstable");
            driver = new FirefoxDriver(profile);
            driver.manage().window().maximize();
        }/*
        else if (EnvConfigurator.browser().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (EnvConfigurator.browser().equals("phantomjs")){
            System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "Users\\dcosman\\Documents\\fuel3d-tests\\src\\main\\java\\utils\\phantomjs\\phantomjs");
            driver = new PhantomJSDriver();
        }*/
        return driver;
    }




    private static void initSeleniumEnd() {
        LOGGER.info("===============================================================");
        LOGGER.info("|          Stopping driver (closing browser)                   |");
        LOGGER.info("===============================================================");
        driver.quit();
        LOGGER.debug("===============================================================");
        LOGGER.debug("|         Driver stopped (browser closed)                     |");
        LOGGER.debug("===============================================================\n");
    }

    /**
     * fail if <blockquote><pre>element.ready()</pre></blockquote> return <blockquote><pre>false</pre></blockquote>
     * @param element expected web locator
     */
    protected void assertThatElementIsReady(WebLocator element) {
        assertThat("{ " +  element.toString() + " } was not found!", element.ready(), is(true));
    }
}
