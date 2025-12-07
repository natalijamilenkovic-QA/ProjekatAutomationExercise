package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allProductsHeader;

    @FindBy(id = "search_product")
    WebElement searchInput;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsTitle;

    @FindBy(css = ".productinfo p")
    List<WebElement> productNameElements;

    @FindBy(css = ".single-products")
    List<WebElement> productContainers;

    @FindBy(css = ".product-overlay a.add-to-cart")
    List<WebElement> addToCartButtons;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAllProductsVisible() {
        return allProductsHeader.isDisplayed();
    }

    public void searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    public boolean isSearchResultVisible() {
        return searchedProductsTitle.isDisplayed();
    }

    public List<String> getSearchResultProductNames() {
        return productNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void addFirstProductToCart() {
        WebElement product = productContainers.get(0);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", product);

        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofMillis(300)).perform();

        WebElement addToCartButton = product.findElement(By.cssSelector(".add-to-cart"));

        js.executeScript("arguments[0].click();", addToCartButton);
    }

    public void clickViewCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement viewCartLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[contains(text(), 'View Cart')]"))
        );

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", viewCartLink);

        js.executeScript("arguments[0].click();", viewCartLink);
    }
}
