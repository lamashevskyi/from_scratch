import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step
    public void openPage() {
        driver.get("http://booking.uz.gov.ua/en");
    }

    @Step
    public void typeFromStation(String from) {
        stationFrom.sendKeys(from);
        //wait.until(ExpectedConditions.visibilityOf(autosuggest));
        selectFirstFromAutosuggest(stationFrom);

    }

    @Step
    public void typeToStation(String to) {
        stationTo.sendKeys(to);
        //wait.until(ExpectedConditions.visibilityOf(autosuggest));
        selectFirstFromAutosuggest(stationTo);
    }

    @Step
    public void selectFirstFromAutosuggest(WebElement element) {
        element.findElement(By.xpath("../div[@class='autosuggest']")).findElement(By.xpath("./div")).click();
    }

    @Step
    public void search(String from, String to) {
        typeFromStation(from);
        typeToStation(to);
        searchButton.click();
    }

    @Step
    public boolean resultsNotEmpty() {
        wait.until(ExpectedConditions.visibilityOf(results));
        return results.isDisplayed();
    }

    @Step
    public String getStationFromText() {
        return stationFrom.getAttribute("value");
    }

    @Step
    public String getStationToText() {
        return stationTo.getAttribute("value");
    }

}
