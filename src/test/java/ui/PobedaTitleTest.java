package ui;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.PobedaPage;

import static config.ConfigApp.POBEDA_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PobedaTitleTest  extends BaseTest {
    String url = POBEDA_URL;
    private final PobedaPage pobedaPage = new PobedaPage();

    @Test
    public void openPobedaTest(){
        driver.get(url);




    }
}
