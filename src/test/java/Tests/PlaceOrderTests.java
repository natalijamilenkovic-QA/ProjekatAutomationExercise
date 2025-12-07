package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class PlaceOrderTests extends BaseTest {

    @Test
    public void placeOrderAfterLogin() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible(), "Home page is NOT visible.");

        home.clickLogin();
        LoginPage login = new LoginPage(driver);

        login.enterEmail("itsamiracletome@gmail.com");
        login.enterPassword("asd123");
        login.clickLogin();
        Assert.assertTrue(login.isLoggedIn(),
                "Login was NOT successful — 'Logged in as username' not visible.");

        home.clickProducts();
        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isAllProductsVisible(), "Products page not visible.");

        products.searchProduct("shirt");
        Assert.assertTrue(products.isSearchResultVisible(), "Search results not visible.");

        products.addFirstProductToCart();
        products.clickViewCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isCartPageVisible(), "Cart page did NOT load.");

        cart.clickProceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        Assert.assertTrue(checkout.isAddressDetailsVisible(),
                "Address Details section NOT visible.");
        Assert.assertTrue(checkout.isReviewOrderVisible(),
                "Review Order section NOT visible.");

        checkout.enterComment("Please deliver quickly. Thank you!");
        checkout.clickPlaceOrder();

        PaymentPage payment = new PaymentPage(driver);

        payment.enterPaymentDetails("Natalija Milenkovic", "123", "123", "12", "2028");
        payment.clickPayAndConfirm();

        Assert.assertTrue(payment.isOrderSuccessMessageVisible(),
                "Order success message NOT visible.");
    }
}
