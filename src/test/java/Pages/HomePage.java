package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// valid email: itsamiracletome@gmail.com i valid password: asd123

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    public WebElement loginButton;

    @FindBy(xpath = "//body")
    public WebElement bodyElement;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    public WebElement productsButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isHomePageVisible() {
        return bodyElement.isDisplayed();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickProducts() {
        productsButton.click();
    }
}
