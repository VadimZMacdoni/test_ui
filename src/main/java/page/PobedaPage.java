package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PobedaPage extends BasePage {
    public PobedaPage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PobedaPage() {

    }

    private WebDriverWait wait;

    @FindBy(css="[aria-label=\"Найти\"]")
    WebElement searchString;

    @FindBy(css="h3")
    WebElement firstLink;

    @FindBy(xpath="//div[text()='Полетели в Калининград!']")
    WebElement bannerText;

    @FindBy(css="button.dp-mj9o31-root-root")
    WebElement changeLangButton;

    @FindBy(xpath="//div[text()='English']/..")
    WebElement engLangButton;

    @FindBy(xpath="//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Ticke')]/..")
    WebElement textTicketSearch;

    @FindBy(xpath="//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Online check-in')]/..")
    WebElement textOnlineCheckIn;

    @FindBy(xpath="//div[@class='dp-ngyzh1-root-textHidden' and starts-with(text(), 'Manage my booking')]/..")
    WebElement textManageMyBooking;

    @Step("Кликнуть на строку поиска")
    public void clickSearchString() {
        searchString.click();
    }

    @Step("Ввести в строку поиска 'Сайт компании Победа'")
    public void enterSearchWords(String searchWords) {
        searchString.sendKeys(searchWords);
    }

    @Step("Кликнуть на кнопку 'Найти'")
    public void getSearchResults() {
        searchString.sendKeys(Keys.ENTER);
    }

    @Step("Кликнуть на кнопку первую ссылку")
    public void clickFirstLink() {
        firstLink.click();
    }

    @Step("Отображается баннер 'Полетели в Калининград'")
    public WebElement bannerTextVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        return wait.until(ExpectedConditions.visibilityOf(bannerText));
    }

    @Step("Кликнуть на кнопку переключения языка")
    public void clickChangeLangButton() {
        changeLangButton.click();
    }

    @Step("Кликнуть на кнопку английского языка")
    public void clickEngLangButton() {
        engLangButton.click();
    }

    @Step("Отображается текст '{text1}'")
    public boolean textTicketSearchVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(textTicketSearch, text));
    }

    @Step("Отображается текст '{text2}'")
    public boolean textOnlineCheckInVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(textOnlineCheckIn, text));
    }

    @Step("Отображается текст '{text3}'")
    public boolean textManageMyBookingVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(textManageMyBooking, text));
    }
}