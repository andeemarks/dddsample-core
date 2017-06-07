package se.citerus.dddsample.acceptance;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public abstract class AbstractAcceptanceTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new PhantomJSDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();

    }
}