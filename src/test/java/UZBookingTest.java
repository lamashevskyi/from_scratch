import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UZBookingTest {

    WebDriver driver;
    UZBookingPage UZ;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        UZ = PageFactory.initElements(driver, UZBookingPage.class);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test (enabled = true)
    public void enterStationFromAndSelectAutosuggestion() {
        UZ.openPage();
        UZ.typeFromStation("Kyi");
        Assert.assertEquals(UZ.getStationFromText(), "Kyiv", "Station From is incorrect");
    }

    @Test (enabled = true)
    public void enterStationToAndSelectAutosuggestion() {
        UZ.openPage();
        UZ.typeToStation("Ode");
        Assert.assertEquals(UZ.getStationToText(), "Odesa", "Station To is incorrect");
    }

    @Test (enabled = true)
    public void trainSearch() {
        UZ.openPage();
        UZ.search("Kyi", "Ode");
        Assert.assertTrue(UZ.resultsNotEmpty());
    }
}
