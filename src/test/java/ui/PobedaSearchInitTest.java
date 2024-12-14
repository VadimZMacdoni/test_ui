package ui;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.PobedaPage;

import static config.ConfigApp.POBEDA_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PobedaSearchInitTest extends BaseTest {

    String url = POBEDA_URL;
    private final PobedaPage pobedaPage = new PobedaPage();

    @Test
    public void infoTest() {
        driver.get(url);

        pobedaPage.scrollTicketsBlock();
        assertTrue(pobedaPage.whereFromFieldVisible());
        assertTrue(pobedaPage.whereToFieldVisible());
        assertTrue(pobedaPage.whereFromDateFieldVisible());
        assertTrue(pobedaPage.whereToDateFieldVisible());

        pobedaPage.enterWhereFromField("Москва");
        pobedaPage.enterwhereToField("Санкт-Петербург");
        pobedaPage.clickSearchButton();
        assertTrue(pobedaPage.whereToDateFieldReadBoardVisible());

    }
}
