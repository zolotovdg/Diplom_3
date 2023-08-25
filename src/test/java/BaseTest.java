import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.BrowserName;
import utils.WebDriverFactory;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void baseSetup() {
        driver = WebDriverFactory.getDriver(BrowserName.CHROME);
        RestAssured.baseURI= "https://stellarburgers.nomoreparties.site/api";
        RestAssured.requestSpecification = new RequestSpecBuilder().addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
