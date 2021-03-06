package se.citerus.dddsample.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AdminPage {
    private final WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        assertEquals("Cargo Administration", driver.getTitle());
    }

    public void listAllCargo() {
        driver.findElement(By.linkText("List all cargos")).click();
        assertEquals("Cargo Administration", driver.getTitle());
    }

    public CargoBookingPage bookNewCargo() {
        driver.findElement(By.linkText("Book new cargo")).click();

        return new CargoBookingPage(driver);
    }

    public boolean listedCargoContains(String expectedTrackingId) {
        List<WebElement> cargoList = driver.findElements(By.cssSelector("#body table tbody tr td a"));
        Optional<WebElement> matchingCargo = cargoList.stream().filter(cargo -> cargo.getText().equals(expectedTrackingId)).findFirst();
        return matchingCargo.isPresent();
    }

    public CargoDetailsPage showDetailsFor(String cargoTrackingId) {
        driver.findElement(By.linkText(cargoTrackingId)).click();

        return new CargoDetailsPage(driver);
    }

    public String routingStatusForCargo(String cargoTrackingId) {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        for (WebElement row : rows) {
            String currentCargoTrackingId = row.findElement(By.xpath("./td[1]")).getText();
            if (currentCargoTrackingId.equalsIgnoreCase(cargoTrackingId)) {
                return row.findElement(By.xpath("./td[4]")).getText();
            }
        }
        return null;
    }

    public void expectCargoIsRouted(String trackingId) {
        assertEquals("Route status for cargo has not been updated", "Yes", routingStatusForCargo(trackingId));
    }

    public void expectCargoIsMisrouted(String trackingId) {
        assertEquals("Route status for cargo has not been updated", "MisroutedYes", routingStatusForCargo(trackingId));
    }

    public void expectCargoIsNotRouted(String trackingId) {
        assertEquals("Route status for cargo has not been updated", "No", routingStatusForCargo(trackingId));
    }
}
