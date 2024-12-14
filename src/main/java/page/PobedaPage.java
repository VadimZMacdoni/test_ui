package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

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
    private final By logo = By.cssSelector(".dp-1e99pvw-root");
    private final By information = By.xpath("//a[@class='dp-ynj85s-root-root-root' and contains(text(),'Информация')]");
    private final By headerPreparingForFlight = By.xpath("//a[@class='dp-14ry67i-root-root' and contains(text(),'Подготовка к полету')]");
    private final By headerUsefulInfo = By.xpath("//a[@class='dp-14ry67i-root-root' and contains(text(),'Полезная информация')]");
    private final By headerAboutCompany = By.xpath("//a[@class='dp-14ry67i-root-root' and contains(text(),'О компании')]");
    private final By ticketsBlock = By.cssSelector(".dp-7yvu2o-root-card");
    private final By whereFromField = By.cssSelector("input[placeholder='Откуда'][spellcheck='false']");
    private final By whereToField = By.cssSelector("input[placeholder='Куда'][spellcheck='false']");
    private final By whereFromDateField = By.cssSelector(".dp-9qwv4e-root input[placeholder='Туда']");
    private final By whereToDateField = By.cssSelector(".dp-9qwv4e-root input[placeholder='Обратно']");
    private final By searchButton = By.xpath("//span[@class='dp-wjta0n-root' and contains(text(), 'Поиск')]");
    private final By whereToDateFieldReadBoard = By.cssSelector(".dp-9qwv4e-root div[class='dp-160ms03-root'][data-failed='true']");

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
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(textTicketSearch), text));
    }

    @Step("Отображается текст '{text2}'")
    public boolean textOnlineCheckInVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(textOnlineCheckIn), text));
    }

    @Step("Отображается текст '{text3}'")
    public boolean textManageMyBookingVisible(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(textManageMyBooking), text));
    }


    @Step("Отображается корректный заголовок сайта")
    public boolean headTitleVisible() {
        return Objects.equals(driver.getTitle(), "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
    }

    @Step("Отображается логотип")
    public WebElement logoVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(logo)));
    }

    @Step("Наведение мыши на пункт 'Информация'")
    public void moveToInformaion() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(information)).perform();
    }

    @Step("Отображается заголовок 'Подготовка к полету'")
    public boolean headerPreparingForFlightVisible() {
        return driver.findElement(headerPreparingForFlight).isDisplayed();
    }

    @Step("Отображается заголовок 'Полезная информация'")
    public boolean headerUsefulInfoVisible() {
        return driver.findElement(headerUsefulInfo).isDisplayed();
    }

    @Step("Отображается заголовок 'О компании'")
    public boolean headerAboutCompanyVisible() {
        return driver.findElement(headerAboutCompany).isDisplayed();
    }

    @Step("Скролл к блоку поиска билета")
    public void scrollTicketsBlock() {
        WebElement element = driver.findElement(ticketsBlock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Отображается блок билетов")
    public boolean ticketsBlockVisible() {
        return driver.findElement(ticketsBlock).isDisplayed();
    }

    @Step("Отображается поле 'Откуда'")
    public boolean whereFromFieldVisible() {
        return driver.findElement(whereFromField).isDisplayed();
    }

    @Step("Отображается поле 'Куда'")
    public boolean whereToFieldVisible() {
        return driver.findElement(whereToField).isDisplayed();
    }

    @Step("Отображается поле 'Туда'")
    public boolean whereFromDateFieldVisible() {
        return driver.findElement(whereFromDateField).isDisplayed();
    }

    @Step("Отображается поле 'Обратно'")
    public boolean whereToDateFieldVisible() {
        return driver.findElement(whereToDateField).isDisplayed();
    }

    @Step("Ввести в поле 'Откуда' 'Москва'")
    public void enterWhereFromField(String searchWords) {
        driver.findElement(whereFromField).sendKeys(searchWords);
    }

    @Step("Ввести в поле 'Туда' 'Санкт-Петербург'")
    public void enterwhereToField(String searchWords) {
        driver.findElement(whereToField).sendKeys(searchWords);
    }

    @Step("Кликнуть на кнопку поиска")
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    @Step("Отображается красная обводка вокруг поля 'Туда'")
    public boolean whereToDateFieldReadBoardVisible() {
        return driver.findElement(whereToDateFieldReadBoard).isDisplayed();
    }


}