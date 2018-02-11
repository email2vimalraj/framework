import com.altimetrik.annotations.NeedBrowser;
import com.altimetrik.drivers.DriverManager;
import com.rationaleemotions.page.Label;
import com.rationaleemotions.page.Link;
import com.rationaleemotions.page.PageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {

//    private RemoteWebDriver driver;

//    @BeforeClass
//    public void setup() {
//        RemoteWebDriver rwd = DriverFactory.createInstance("chrome");
//        DriverManager.setDriver(rwd);
//        driver = DriverManager.getDriver();
//    }

    @NeedBrowser(name = "chrome")
    @Test
    public void testMethod() {
//        Driver driverObj = new Driver();
//        driver = driverObj.getRemoteWebDriver();
        RemoteWebDriver driver = DriverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com/");
        PageObject homePage = new PageObject(driver, "src/test/resources/HomePage.json");
        Label heading = homePage.getLabel("heading");
        Assert.assertEquals(heading.getText(), "Welcome to the-internet");

        Link checkbox = homePage.getLink("checkboxesLink");
        Assert.assertEquals(checkbox.isDisplayed(), true);
//        driver.quit();
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
