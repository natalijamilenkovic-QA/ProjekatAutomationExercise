package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PaymentPage {

    WebDriver driver;

    @FindBy(name = "name_on_card")
    WebElement cardNameField;

    @FindBy(name = "card_number")
    WebElement cardNumberField;

    @FindBy(name = "cvc")
    WebElement cvcField;

    @FindBy(name = "expiry_month")
    WebElement expiryMonthField;

    @FindBy(name = "expiry_year")
    WebElement expiryYearField;

    @FindBy(id = "submit")
    WebElement payAndConfirmButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement successMessage;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPaymentDetails(String name, String number, String cvc, String month, String year) {
        cardNameField.sendKeys(name);
        cardNumberField.sendKeys(number);
        cvcField.sendKeys(cvc);
        expiryMonthField.sendKeys(month);
        expiryYearField.sendKeys(year);
    }

    public void clickPayAndConfirm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", payAndConfirmButton);
    }

    public boolean isOrderSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
}
