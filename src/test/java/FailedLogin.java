import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FailedLogin {

    @Test
    public void main() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("failed_user");
        driver.findElement(By.id("password")).sendKeys("secret_failed");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String errorLoginAssert = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(errorLoginAssert, "Epic sadface: Username and password do not match any user in this service");
    }
}
