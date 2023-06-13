package pageObject;

import org.openqa.selenium.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderPage {
    private WebDriver driver;
    // локатор для верхней кнопки заказать
    private By orderButtonUp = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    // локатор для нижней кнопки заказать
    private By orderButtonDown = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    //локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    //локаторы первой страницы оформления заказа
    //локатор для поля имя
    private By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //локатор для поля фамилия
    private By lastNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //лоатор для адреса
    private By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //локатор для метро
    private By metroField = By.className("select-search__input");
    //локатор для номер телефона
    private By phoneNumField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //локатор для кнопки далее
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //локаторы второй страницы оформления заказа
    //локатор даты доставки самоката
    private By deliveryDateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    //локатор срока аренды самоката
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //локатор выбора цвета самоката
    private By colorField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]");
    //локатор поля для комментариев
    private By commentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    //локатор кнопки заказать на второй странице оформления заказа
    private By orderButtonInOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    //третья страница заказа с подтверждением заказа
    //локтор для кнопки да
    private By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    //четвертая страница заказа с информацие, что заказ оформлен.
    //локатор текста с информацией о заказе
    private By orderInfo = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    //метод для принятия куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //метод для нажатия верхней кнопки заказать
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }
    //метод для прокрутки до нижней кнопки заказать и нажатие на нее
    public void clickOrderButtonDown() {
        WebElement button = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(orderButtonDown).click();
    }
    //метод заполнения поля имя
    public void setFirstNameField (String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //метод заполнения поля фамилия
    public void setLastNameField (String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    //метод заполнения поля адрес
    public void setAddressNameField (String addressName) {
        driver.findElement(addressField).sendKeys(addressName);
    }
    //метод заполнения поля метро
    public void clickMetroField1() {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//button[@value='1']")).click();
    }
    public void clickMetroField2() {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//button[@value='2']")).click();
    }

    //метод заполнения поля номер телефона
    public void setPhoneNumField (String number) {
        driver.findElement(phoneNumField).sendKeys(number);
    }
    //метод для заполнения данных в певой странице оформления заказа
    public void login (String firstName, String lastName, String addressName, String number) {
        setFirstNameField(firstName);
        setLastNameField(lastName);
        setAddressNameField(addressName);
        setPhoneNumField(number);
    }
    //метод нажатие кнопки далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //метод заполнения поля дата доставки
    public void setDeliveryDateField() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        Date date = new Date();
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateField).sendKeys(formatter.format(date));
        driver.findElement(deliveryDateField).sendKeys(Keys.ENTER);
    }
    //метод заполнения поля срок аренды
    public void setRentalPeriodField1() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodField).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
        }
        public void setRentalPeriodField2() {
            driver.findElement(rentalPeriodField).click();
            driver.findElement(rentalPeriodField).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]")).click();
        }
        //метод заполнения поля цвета самоката
        public void setColorField1() {
            driver.findElement(colorField);
            driver.findElement(By.xpath("//*[@id=\"black\"]")).click();
        }
        public void setColorField2() {
            driver.findElement(colorField);
            driver.findElement(By.xpath("//*[@id=\"grey\"]")).click();
        }
        //метод заполнения поля комментарии
        public void setCommentField(String comment) {
            driver.findElement(commentField).sendKeys(comment);
        }
        //метод нажатия кнопки заказать после оформления заказа
        public void clickOrderButtonInOrder() {
            driver.findElement(orderButtonInOrder).click();
        }
        //метод нажатия кнопки да
        public void clickYesButton() {
            driver.findElement(yesButton).click();
        }
        //метод для проверки, что появляется текст об успешном создании заказа
        public void printOrderInfo() {
            String text = driver.findElement(orderInfo).getText();
            System.out.println("Текст сообщения " + text);
        }

    }
