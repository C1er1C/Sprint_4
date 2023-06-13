package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //локатор для списка вопросов
    private By questionList = By.className("accordion");
    //локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //метод для принятия куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //метод прокрутки до списка вопросов
    public void scrollToQuestionList() {
        WebElement element = driver.findElement(questionList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //методы нажатия на кнопки с вопросами
    public void clickFirstQuestions() {
        driver.findElement(By.id("accordion__heading-0")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickSecondQuestion() {
        driver.findElement(By.id("accordion__heading-1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickThirdQuestion() {
        driver.findElement(By.id("accordion__heading-2")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickFourthQuestion() {
        driver.findElement(By.id("accordion__heading-3")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickFifthQuestion() {
        driver.findElement(By.id("accordion__heading-4")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickSixthQuestion() {
        driver.findElement(By.id("accordion__heading-5")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickSeventhQuestion() {
        driver.findElement(By.id("accordion__heading-6")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void clickEighthQuestion() {
        driver.findElement(By.id("accordion__heading-7")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    //методы возвращаюшие текст ответа на вопрос
    public String getFirstAnswer() {
        return driver.findElement(By.id("accordion__panel-0")).getText();
    }
    public String getSecondAnswer() {
        return driver.findElement(By.id("accordion__panel-1")).getText();
    }
    public String getThirdAnswer() {
        return driver.findElement(By.id("accordion__panel-2")).getText();
    }
    public String getFourthAnswer() {
        return driver.findElement(By.id("accordion__panel-3")).getText();
    }
    public String getFifthAnswer() {
        return driver.findElement(By.id("accordion__panel-4")).getText();
    }
    public String getSixthAnswer() {
        return driver.findElement(By.id("accordion__panel-5")).getText();
    }
    public String getSeventhAnswer() {
        return driver.findElement(By.id("accordion__panel-6")).getText();
    }
    public String getEighthAnswer() {
        return driver.findElement(By.id("accordion__panel-7")).getText();
    }
}
