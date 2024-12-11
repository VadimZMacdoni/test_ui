package ui;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.PikabuPage;

import static config.ConfigApp.PIKABU_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PikabuTest extends BaseTest {
    String url = PIKABU_URL;
    private final PikabuPage pikabuPage = new PikabuPage();

    @Test
    public void authPikabuTest(){
        driver.get(url);

        assertTrue(pikabuPage.headTitleVisible());

        pikabuPage.clickLoginButton();

        assertTrue(pikabuPage.authWindowVisible());
        assertTrue(pikabuPage.loginFieldVisible());
        assertTrue(pikabuPage.pwdFieldVisible());
        assertTrue(pikabuPage.loginButtonInAuthWindowVisible());

        pikabuPage.enterLogin("Qwerty");
        pikabuPage.enterPassword("Qwerty");
        pikabuPage.clickLoginButtonInAuthWindow();

        assertTrue(pikabuPage.errorMessageVisible());
    }
}
