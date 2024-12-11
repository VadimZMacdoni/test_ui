package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

import java.util.Objects;

public class PikabuPage extends BasePage {
    public PikabuPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public PikabuPage() {

    }

    private final By loginButton = By.xpath("//button[contains(@class, 'header-right-menu__login-button')]");
    private final By authWindow = By.xpath("//div[contains(@class, 'popup__container')]");
    private final By loginField = By.cssSelector("div.popup__container input[type='text'][name='username'][placeholder='Логин']");
    private final By pwdField = By.cssSelector("div.popup__container input[type='password'][name='password'][placeholder='Пароль']");
    private final By loginButtonInAuthWindow = By.xpath("//span[text()='Войти']/..");
    private final By errorMessage = By.xpath("//span[text()='Ошибка. Вы ввели неверные данные авторизации']");

    @Step("Отображается корректный заголовок сайта")
    public boolean headTitleVisible() { return Objects.equals(driver.getTitle(), "Горячее – самые интересные и обсуждаемые посты | Пикабу");}

    @Step("Кликнуть на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Отображается окно авторизации}")
    public boolean authWindowVisible() {
        return driver.findElement(authWindow).isDisplayed();
    }

    @Step("Отображается поле 'Логин'")
    public boolean loginFieldVisible() {
        return driver.findElement(loginField).isDisplayed();
    }

    @Step("Отображается поле 'Пароль'")
    public boolean pwdFieldVisible() {
        return driver.findElement(pwdField).isDisplayed();
    }

    @Step("Отображается кнопка 'Войти'")
    public boolean loginButtonInAuthWindowVisible() {
        return driver.findElement(loginButtonInAuthWindow).isDisplayed();
    }

    @Step("Ввести логин")
    public void enterLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(pwdField).sendKeys(password);
    }

    @Step("Кликнуть на кнопку 'Войти' в окне авторизации")
    public void clickLoginButtonInAuthWindow() {
        //driver.findElement(loginButtonInAuthWindow).click();
        driver.findElement(pwdField).sendKeys(Keys.ENTER);
    }

    @Step("Отображается сообщение об ошибке")
    public boolean errorMessageVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

}
