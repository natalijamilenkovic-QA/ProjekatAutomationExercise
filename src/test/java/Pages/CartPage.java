package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CartPage {
    WebDriver driver;

    @FindBy(css = "td.cart_description h4 a")
    WebElement productNameInCart;

    @FindBy(xpath = "//ol[contains(@class,'breadcrumb')]//*[contains(text(),'Shopping Cart')]")
    WebElement cartBreadcrumb;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageVisible() {
        return cartBreadcrumb.isDisplayed();
    }

    public String getProductName() {
        return productNameInCart.getText();
    }

    public void clickProceedToCheckout() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceedToCheckoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedToCheckoutButton);
    }
}
