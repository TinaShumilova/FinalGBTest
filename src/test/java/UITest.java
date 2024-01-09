import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UITest extends AbstractTest{

    @Test
    void testGBNotEmailLogin() {
        driver.get("https://gb.ru/login");
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.loginWithWrongUserName("login", "password");

        Assertions.assertFalse(loginPage.checkTextUnderUserName().isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        driver.get("https://gb.ru/login");
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.loginWithoutPassword("login@login.ru");

        Assertions.assertFalse(loginPage.checkTextUnderPassword().isEmpty());

    }

}
