package ui;

import config.ConfigApp;
import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.PikabuPage;
import page.PobedaPage;

import static config.ConfigApp.GOOGLE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PobedaTest extends BaseTest {
    String url = GOOGLE_URL;
    private final PobedaPage pobedaPage = new PobedaPage();

    @Test
    public void authPikabuTest(){
        driver.get(url);

        pobedaPage.clickSearchString();
        pobedaPage.enterSearchWords("Сайт компании Победа");
        pobedaPage.getSearchResults();
        pobedaPage.clickFirstLink();

        pobedaPage.bannerTextVisible();

        pobedaPage.clickChangeLangButton();
        pobedaPage.clickEngLangButton();

        assertTrue(pobedaPage.textTicketSearchVisible("Ticket search"));
        assertTrue(pobedaPage.textOnlineCheckInVisible("Online check-in"));
        assertTrue(pobedaPage.textManageMyBookingVisible("Manage my booking"));
    }
}
