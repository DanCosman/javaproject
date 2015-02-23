package org.fasttrackit.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by dcosman on 23/02/15.
 */
public class InitWebDriver {
    public static WebDriver driver;

    public static WebDriver initWebDriver() {

        if (EnvConfigurator.browser().equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(true);
            profile.setPreference("webdriver.load.strategy", "unstable");
            driver = new FirefoxDriver(profile);
            driver.manage().window().maximize();
        }
        else if (EnvConfigurator.browser().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            driver = new ChromeDriver();
        }/*
        else if (EnvConfigurator.browser().equals("phantomjs")){
            System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "Users\\dcosman\\Documents\\fuel3d-tests\\src\\main\\java\\utils\\phantomjs\\phantomjs");
            driver = new PhantomJSDriver();
        }*/
        return driver;
    }
}
