package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.ProductsPage;

import java.util.List;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProduct_validateResultsMatchKeyword() {
        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isAllProductsVisible(), "All Products page is not displayed");

        String keyword = "Men Tshirt";
        products.searchProduct(keyword);

        Assert.assertTrue(products.isSearchResultVisible(), "'Searched Products' title not visible");

        List<String> results = products.getSearchResultProductNames();
        System.out.println("Results found: " + results);

        Assert.assertFalse(results.isEmpty(), "No search results found!");

        for (String product : results) {
            boolean match = product.toLowerCase().contains(keyword.toLowerCase());
            Assert.assertTrue(match, "Product name does NOT match keyword → Expected to contain: " + keyword + " | Actual product: " + product);
        }
    }
}
