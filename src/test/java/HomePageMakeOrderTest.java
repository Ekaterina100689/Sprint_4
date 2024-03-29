import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class HomePageMakeOrderTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void makeOrder() {
        String[][] data = new String[][]{
                {"Петя", "Иванов", "Москва", "Черкизовская", "+79259999999", "10.02.2023"},
                {"Коля", "Петров", "Москва", "Крымская", "+79257777777", "11.02.2023"},
        };
        for(int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://qa-scooter.praktikum-services.ru/");
                HomePage homePage = new HomePage(driver);
                homePage.clickOnOrderButton(i);
                OrderPageFirst orderPageFirst = new OrderPageFirst(driver);
                orderPageFirst.fillFormAndClickNextButton(data[j][0], data[j][1], data[j][2], data[j][3], data[j][4]);
                OrderPageSecond orderPageSecond = new OrderPageSecond(driver);
                assertTrue(orderPageSecond.setFieldsAndClickOrderButton(data[j][5]));
            }
        }

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}