package se.citerus.dddsample.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class CargoRoutingPage {
    private final WebDriver driver;

    public CargoRoutingPage(WebDriver driver) {
        this.driver = driver;

        WebElement newCargoTableCaption = driver.findElement(By.cssSelector("table caption"));

        assertTrue(newCargoTableCaption.getText().startsWith("Select route"));

    }

    public CargoDetailsPage assignRoute() {
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        return new CargoDetailsPage(driver);
    }
}
