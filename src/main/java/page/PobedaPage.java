package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PobedaPage extends BasePage {
    public PobedaPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public PobedaPage() {

    }

    private WebDriverWait wait;

    private final By searchString = By.cssSelector("[aria-label=\"Найти\"]");
    private final By firstLink = By.cssSelector("h3");
    private final By bannerText = By.xpath("//div[text()='Полетели в Калининград!']");
    private final By changeLangButton = By.cssSelector("button.dp-mj9o31-root-root");
    private final By engLangButton = By.xpath("//div[text()='English']/..");
    private final By textTicketSearch = By.xpath("//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Ticke')]/..");
    private final By textOnlineCheckIn = By.xpath("//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Online check-in')]/..");
    private final By textManageMyBooking = By.xpath("//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Manage my booking')]/..");

    @Step("Кликнуть на строку поиска")
    public void clickSearchString() {
        driver.findElement(searchString).click();
    }

    @Step("Ввести в строку поиска 'Сайт компании Победа'")
    public void enterSearchWords(String searchWords) {
        driver.findElement(searchString).sendKeys(searchWords);
    }

    @Step("Кликнуть на кнопку 'Найти'")
    public void getSearchResults() {
        driver.findElement(searchString).sendKeys(Keys.ENTER);
    }

    @Step("Кликнуть на кнопку первую ссылку")
    public void clickFirstLink() {
        driver.findElement(firstLink).click();
    }

    @Step("Отображается баннер 'Полетели в Калининград'")
    public WebElement bannerTextVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(bannerText)));
    }

    @Step("Кликнуть на кнопку переключения языка")
    public void clickChangeLangButton() {
        driver.findElement(changeLangButton).click();
    }

    @Step("Кликнуть на кнопку английского языка")
    public void clickEngLangButton() {
        driver.findElement(engLangButton).click();
    }

    @Step("Отображается текст '{text1}'")
    public boolean textTicketSearchVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.
                findElement(textTicketSearch), text));
    }

    @Step("Отображается текст '{text2}'")
    public boolean textOnlineCheckInVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.
                findElement(textOnlineCheckIn), text));
    }

    @Step("Отображается текст '{text3}'")
    public boolean textManageMyBookingVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.
                findElement(textManageMyBooking), text));
    }
}