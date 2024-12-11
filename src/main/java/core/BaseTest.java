package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static config.ConfigApp.CHROME_DRIVER;

abstract public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        //WebDriverManager.chromedriver().driverVersion(CHROME_DRIVER).setup();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VMZufarov\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
    }


    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
