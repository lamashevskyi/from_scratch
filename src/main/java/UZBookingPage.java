import org.openqa.selenium.WebDriver;

public class UZBookingPage {

    WebDriver driver;

    public UZBookingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get("http://booking.uz.gov.ua/en");
    }
}
