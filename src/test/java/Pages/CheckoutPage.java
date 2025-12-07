package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    WebElement addressDetailsSection;

    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    WebElement reviewOrderSection;

    @FindBy(name = "message")
    WebElement commentTextArea;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAddressDetailsVisible() {
        return addressDetailsSection.isDisplayed();
    }

    public boolean isReviewOrderVisible() {
        return reviewOrderSection.isDisplayed();
    }

    public void enterComment(String text) {
        commentTextArea.sendKeys(text);
    }

    public void clickPlaceOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);
    }
}
