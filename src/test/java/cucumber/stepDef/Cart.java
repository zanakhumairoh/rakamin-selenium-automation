package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user have to login first to cart")
    public void userHaveToLoginFirstToCart() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input (.*) as user_name to cart$")
    public void userInputUser_nameAsUser_nameToCart(String user_name) {
        driver.findElement(By.id("user-name")).sendKeys(user_name);
    }

    @And("user input (.*) as password to cart$")
    public void userInputPasswordAsPasswordToCart(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click submit to cart")
    public void userClickSubmitToCart() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("user click Add to cart on all product to cart")
    public void userClickAddToCartOnAllProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    }

    @And("user click cart button")
    public void userClickCartButton() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("user verify (.*) cart result$")
    public void userVerifyStatusCartResult(String status) {
        if (status.equals("success")) {
            String cartPageAssert = driver.findElement(By.className("title")).getText();
            Assert.assertEquals(cartPageAssert, "Your Cart");
        }
    }
}
