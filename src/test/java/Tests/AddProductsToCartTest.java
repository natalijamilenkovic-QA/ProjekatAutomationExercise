package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ProductsPage;
import Pages.CartPage;
import Pages.HomePage;

public class AddProductsToCartTest extends BaseTest {

    @Test
    public void addProductToCartAndVerify() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible.");

        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isAllProductsVisible(), "ALL PRODUCTS page not visible.");

        String keyword = "shirt";
        products.searchProduct(keyword);

        Assert.assertTrue(products.isSearchResultVisible(), "Search results title not visible.");

        products.addFirstProductToCart();

        products.clickViewCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isCartPageVisible(), "Cart page is not displayed.");

        String productName = cart.getProductName().toLowerCase();
        System.out.println("Product in cart: " + productName);

        Assert.assertTrue(
                productName.contains(keyword.toLowerCase()),
                "Product added to cart does NOT match search keyword! Expected keyword: " +
                        keyword + " | Actual product: " + productName
        );

        System.out.println("Product successfully added to cart and validated.");
    }
}
