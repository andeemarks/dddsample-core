package se.citerus.dddsample.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LaunchPage {
    public static final String BASEURL = "http://localhost:8080/dddsample";
    private final WebDriver driver;

    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(BASEURL);
        assertEquals("DDDSample", driver.getTitle());
    }

    public CustomerPage goToCustomerPage() {
        driver.findElement(By.linkText("cargo tracking")).click();

        return new CustomerPage(driver);
    }

    public AdminPage goToAdminPage() {
        driver.findElement(By.linkText("booking and routing")).click();

        return new AdminPage(driver);
    }
}
