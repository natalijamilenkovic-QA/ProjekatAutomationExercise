package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidUserTest extends BaseTest {

    @Test
    public void loginWithCorrectEmailPassword() {
        HomePage hp = new HomePage(driver);
        Assert.assertTrue(hp.isHomePageVisible(), "HomePage is not visible");

        hp.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginHeaderVisible(),
                "Login to your account is not visible");

        loginPage.enterEmail("itsamiracletome@gmail.com");
        loginPage.enterPassword("asd123");

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoggedIn(), "User is logged in!");
    }


}
