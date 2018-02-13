import com.altimetrik.annotations.NeedBrowser;
import com.altimetrik.drivers.DriverManager;
import com.altimetrik.pagefactory.HomePage;
import com.altimetrik.pagefactory.PageFactory;
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
//        PageObject homePage = new PageObject(driver, "src/test/resources/pageobjects/HomePage.json");
//        Label heading = homePage.getLabel("heading");
//        Assert.assertEquals(heading.getText(), "Welcome to the-internet");
//
//        Link checkbox = homePage.getLink("checkboxesLink");
//        Assert.assertEquals(checkbox.isDisplayed(), true);
        HomePage homePage = PageFactory.getHomePage(driver);
//        HomePage homePage = org.openqa.selenium.support.PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homePage.getHeadingText(), "Welcome to the-internet");
//        driver.quit();
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @NeedBrowser(name = "chrome")
    @Test
    public void pageFactoryTest() {
        RemoteWebDriver driver = DriverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com");
        HomePage homePage = new HomePage(driver);
//        ElementLocatorFactory factory = new CustomElementLocatorFactory(driver);
//        org.openqa.selenium.support.PageFactory.initElements(new CustomFieldDecorator(driver), homePage);
        System.err.println(homePage.getHeadingText());
    }
}
