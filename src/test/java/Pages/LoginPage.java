package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
    public WebElement loginHeader;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    public WebElement incorrectCredentialsError;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    public WebElement loggedInAsText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isLoginHeaderVisible() {
        return loginHeader.isDisplayed();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isErrorMessageVisible() {
        return incorrectCredentialsError.isDisplayed();
    }

    public boolean isLoggedIn() {
        return loggedInAsText.isDisplayed();
    }
}
