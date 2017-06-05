package se.citerus.dddsample.acceptance;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public abstract class AbstractAcceptanceTest {
    protected WebDriver driver;

    @Before
    public void setup() {
        driver = new PhantomJSDriver();
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}