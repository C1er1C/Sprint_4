import pageObject.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class TestOrder {
    private WebDriver driver;
    OrderPage NewOrder;

    @Before
    public void setUp() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        NewOrder = new OrderPage(driver);
        NewOrder.clickCookie();
    }
    @Test
    //первый набор тест данных
    public void checkOrder1() {
        NewOrder.clickOrderButtonUp();
        NewOrder.login("Олег", "Самокатов", "Советская 60", "88002353535");
        NewOrder.clickMetroField1();
        NewOrder.clickNextButton();
        NewOrder.setDeliveryDateField();
        NewOrder.setRentalPeriodField1();
        NewOrder.setColorField1();
        NewOrder.setCommentField("o______o");
        NewOrder.clickOrderButtonInOrder();
        NewOrder.clickYesButton();
        NewOrder.printOrderInfo();
    }
    @Test
    //второй набор тест данных
    public void checkOrder2() {
        NewOrder.clickOrderButtonDown();
        NewOrder.login("Игорь", "Штенге", "Ленина 40", "89049040404");
        NewOrder.clickMetroField2();
        NewOrder.clickNextButton();
        NewOrder.setDeliveryDateField();
        NewOrder.setRentalPeriodField2();
        NewOrder.setColorField2();
        NewOrder.setCommentField("^______^");
        NewOrder.clickOrderButtonInOrder();
        NewOrder.clickYesButton();
        NewOrder.printOrderInfo();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
