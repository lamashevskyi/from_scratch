import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class UZBookingTest extends DriverSetup {

    WebDriver driver;
    UZBookingPage UZ;

    @BeforeMethod
    public void init() {
        driver = getDriver(Browser.CHROME);
        UZ = PageFactory.initElements(driver, UZBookingPage.class);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @DataProvider(name = "stations", parallel = false)
    public Object[][] stationsDataProvider() {
        return new Object[][] {
                {"Kyi", "Kyiv", "Ivano", "Ivano-Frankivsk", "143 К"},
                {"Ivano", "Ivano-Frankivsk", "Kyi", "Kyiv", "143 Л"}
        };
    }

    @Test (dataProvider = "stations", enabled = true)
    public void enterStationFromAndSelectAutosuggestion(String fromShort, String from, String toShort, String to, String trainNumber) {
        UZ.openPage();
        UZ.typeFromStation(fromShort);
        Assert.assertEquals(UZ.getStationFromText(), from, "Station From is incorrect");
    }

    @Test (dataProvider = "stations", enabled = false)
    public void enterStationToAndSelectAutosuggestion(String fromShort, String from, String toShort, String to, String trainNumber) {
        UZ.openPage();
        UZ.typeToStation(toShort);
        Assert.assertEquals(UZ.getStationToText(), to, "Station To is incorrect");
    }

    @Test (dataProvider = "stations", enabled = true)
    public void trainSearch(String fromShort, String from, String toShort, String to, String trainNumber) {
        UZ.openPage();
        UZ.search(fromShort, toShort);
        Assert.assertTrue(UZ.resultsNotEmpty());
    }




}
