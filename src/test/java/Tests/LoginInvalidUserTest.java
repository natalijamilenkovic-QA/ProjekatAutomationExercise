package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidUserTest extends BaseTest {

    @Test
    public void loginWithIncorrectEmailPassword() {
        HomePage hp = new HomePage(driver);
        Assert.assertTrue(hp.isHomePageVisible(), "HomePage is not visible");

        hp.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginHeaderVisible(),
                "Login to your account is not visible");


        loginPage.enterEmail("invalidemail@gmail.com");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isErrorMessageVisible(), "Error message is not shown!");
    }
}
