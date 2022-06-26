package io.testinium.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

    public class BaseTest {

        public static WebDriver webDriver;

        @BeforeScenario
        public void setUp(){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\testinium\\Desktop\\IntellijProje\\BeymenGauge\\driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-translate");
            options.addArguments("disable-notifications");
            options.addArguments("disable-popup-blocking");
            options.addArguments("test-type");
            //options.addArguments("headless");
            setWebDriver(new ChromeDriver(options));
            getWebDriver().get("https://www.google.com.tr");

        }
        @AfterScenario
        public void tearDown() {

            webDriver.quit();
        }
        public WebDriver getWebDriver() {

            return webDriver;
        }

        public void setWebDriver(WebDriver webDriver) {

            BaseTest.webDriver = webDriver;
        }

    }
