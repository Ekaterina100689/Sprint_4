import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageFaqAreaTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void faqAreaCheck() {
        HomePage page = new HomePage(driver);
        assertTrue(page.faqAreaCheck());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}