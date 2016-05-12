import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UZBookingPage {



    @FindBy(name="station_from")
    private WebElement stationFrom;

    @FindBy(name="station_till")
    private WebElement stationTo;

    @FindBy(className="autosuggest")
    private WebElement autosuggest;


    @FindBy(name="search")
    private WebElement searchButton;

    @FindBy(id="ts_res")
    private WebElement results;

    WebDriver driver;

    WebDriverWait wait;

    public UZBookingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void openPage() {
        driver.get("http://booking.uz.gov.ua/en");
    }

    public void typeFromStation(String from) {
        stationFrom.sendKeys(from);
        //wait.until(ExpectedConditions.visibilityOf(autosuggest));
        selectFirstFromAutosuggest(stationFrom);

    }

    public void typeToStation(String to) {
        stationTo.sendKeys(to);
        //wait.until(ExpectedConditions.visibilityOf(autosuggest));
        selectFirstFromAutosuggest(stationTo);
    }

    public void selectFirstFromAutosuggest(WebElement element) {
        element.findElement(By.xpath("../div[@class='autosuggest']")).findElement(By.xpath("./div")).click();
    }

    public void search(String from, String to) {
        typeFromStation(from);
        typeToStation(to);
        searchButton.click();
    }

    public boolean resultsNotEmpty() {
        wait.until(ExpectedConditions.visibilityOf(results));
        return results.isDisplayed();
    }

    public String getStationFromText() {
        return stationFrom.getAttribute("value");
    }

    public String getStationToText() {
        return stationTo.getAttribute("value");
    }


//
//    public static void enterStationFrom(String stationFrom) {
//        driver.findElement(By.name("station_from")).sendKeys(stationFrom);
//    }
}
